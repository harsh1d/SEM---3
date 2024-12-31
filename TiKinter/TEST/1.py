import tkinter as tk
from tkinter import ttk

# Create a library (dictionary) to store user data
user_library = {}

# Function to register a new user
def register_user():
    name = name_entry.get()
    email = email_entry.get()
    contact_number = contact_entry.get()
    gender = gender_var.get()
    hobbies = []
    if cricket_var.get():
        hobbies.append("Cricket")
    if singing_var.get():
        hobbies.append("Singing")
    if acting_var.get():
        hobbies.append("Acting")
    password = password_entry.get()

    # Save user data to the library
    user_library[email] = {
        "name": name,
        "contact_number": contact_number,
        "gender": gender,
        "hobbies": hobbies,
        "password": password
    }

    # Clear entry fields
    name_entry.delete(0, tk.END)
    email_entry.delete(0, tk.END)
    contact_entry.delete(0, tk.END)
    gender_var.set("Select")
    cricket_var.set(False)
    singing_var.set(False)
    acting_var.set(False)
    password_entry.delete(0, tk.END)

    # Show registration success message
    success_label.config(text="Registration successful!")

# Function to log in a user
def login_user():
    email = email_entry.get()
    password = password_entry.get()

    # Check if user exists in the library
    if email in user_library and user_library[email]["password"] == password:
        # Login successful
        success_label.config(text="Login successful!")

        # Display user information in the terminal
        print(f"Welcome, {user_library[email]['name']}!")
        print(f"Email: {email}")
        print(f"Contact Number: {user_library[email]['contact_number']}")
        print(f"Gender: {user_library[email]['gender']}")
        print(f"Hobbies: {', '.join(user_library[email]['hobbies'])}")
    else:
        # Login failed
        success_label.config(text="Invalid email or password")

# Create the main window
window = tk.Tk()
window.title("Registration and Login")

# Create registration and login frames
register_frame = tk.Frame(window)
login_frame = tk.Frame(window)

# Register Frame
# ... (See below for the code for the registration form)
# Registration Frame Widgets
name_label = tk.Label(register_frame, text="Name:")
name_label.grid(row=0, column=0, padx=5, pady=5)
name_entry = tk.Entry(register_frame)
name_entry.grid(row=0, column=1, padx=5, pady=5)

email_label = tk.Label(register_frame, text="Email:")
email_label.grid(row=1, column=0, padx=5, pady=5)
email_entry = tk.Entry(register_frame)
email_entry.grid(row=1, column=1, padx=5, pady=5)

contact_label = tk.Label(register_frame, text="Contact Number:")
contact_label.grid(row=2, column=0, padx=5, pady=5)
contact_entry = tk.Entry(register_frame)
contact_entry.grid(row=2, column=1, padx=5, pady=5)

gender_label = tk.Label(register_frame, text="Gender:")
gender_label.grid(row=3, column=0, padx=5, pady=5)
gender_var = tk.StringVar(register_frame)
gender_var.set("Select")
gender_dropdown = ttk.Combobox(register_frame, textvariable=gender_var, values=["Male", "Female"])
gender_dropdown.grid(row=3, column=1, padx=5, pady=5)

hobbies_label = tk.Label(register_frame, text="Hobbies:")
hobbies_label.grid(row=4, column=0, padx=5, pady=5)
cricket_var = tk.BooleanVar(register_frame)
cricket_checkbox = tk.Checkbutton(register_frame, text="Cricket", variable=cricket_var)
cricket_checkbox.grid(row=4, column=1, padx=5, pady=5)
singing_var = tk.BooleanVar(register_frame)
singing_checkbox = tk.Checkbutton(register_frame, text="Singing", variable=singing_var)
singing_checkbox.grid(row=5, column=1, padx=5, pady=5)
acting_var = tk.BooleanVar(register_frame)
acting_checkbox = tk.Checkbutton(register_frame, text="Acting", variable=acting_var)
acting_checkbox.grid(row=6, column=1, padx=5, pady=5)

password_label = tk.Label(register_frame, text="Password:")
password_label.grid(row=7, column=0, padx=5, pady=5)
password_entry = tk.Entry(register_frame, show="*")
password_entry.grid(row=7, column=1, padx=5, pady=5)

register_button = tk.Button(register_frame, text="Register", command=register_user)
register_button.grid(row=8, column=0, columnspan=2, padx=5, pady=5)

# Login Frame
# ... (See below for the code for the login form)
# Login Frame Widgets
email_label = tk.Label(login_frame, text="Email:")
email_label.grid(row=0, column=0, padx=5, pady=5)
email_entry = tk.Entry(login_frame)
email_entry.grid(row=0, column=1, padx=5, pady=5)

password_label = tk.Label(login_frame, text="Password:")
password_label.grid(row=1, column=0, padx=5, pady=5)
password_entry = tk.Entry(login_frame, show="*")
password_entry.grid(row=1, column=1, padx=5, pady=5)

login_button = tk.Button(login_frame, text="Login", command=login_user)
login_button.grid(row=2, column=0, columnspan=2, padx=5, pady=5)

# Show the registration frame initially
register_frame.pack()

# Success label
success_label = tk.Label(window, text="", fg="green")
success_label.pack()

# Function to switch to the registration frame
def show_register_frame():
    login_frame.pack_forget()
    register_frame.pack()

# Function to switch to the login frame
def show_login_frame():
    register_frame.pack_forget()
    login_frame.pack()

# Create buttons to switch between frames
register_button = tk.Button(window, text="Register", command=show_register_frame)
register_button.pack(pady=5)
login_button = tk.Button(window, text="Login", command=show_login_frame)
login_button.pack(pady=5)

window.mainloop()

# Code for the registration form
# ... (See below for the registration form code)

# Code for the login form
# ... (See below for the login form code)