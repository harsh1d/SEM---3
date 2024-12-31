import tkinter as tk
from tkinter import messagebox

# Dictionary to store user data
users_data = {}

# Function to print the data in the terminal
def print_data(data):
    for key, value in data.items():
        print(f"{key}: {value}")

# Register Function
def register_user():
    name = name_entry.get()
    email = email_entry.get()
    contact = contact_entry.get()
    gender = gender_var.get()
    password = password_entry.get()
    hobbies = [hobbies_listbox.get(i) for i in hobbies_listbox.curselection()]

    if not all([name, email, contact, password]):
        messagebox.showerror("Error", "Please fill all fields.")
        return

    if email in users_data:
        messagebox.showerror("Error", "Email already exists. Please use a different email.")
        return

    users_data[email] = {
        'name': name,
        'contact': contact,
        'gender': gender,
        'password': password,
        'hobbies': hobbies
    }

    messagebox.showinfo("Success", "Registration successful!")
    print_data(users_data[email])

    name_entry.delete(0, tk.END)
    email_entry.delete(0, tk.END)
    contact_entry.delete(0, tk.END)
    password_entry.delete(0, tk.END)
    hobbies_listbox.selection_clear(0, tk.END)
    gender_var.set(None)

# Login Function
def login_user():
    email = email_login_entry.get()
    password = password_login_entry.get()

    if not all([email, password]):
        messagebox.showerror("Error", "Please fill all fields.")
        return

    user = users_data.get(email)
    if user and user['password'] == password:
        messagebox.showinfo("Success", "Login successful!")
        print_data(user)
    else:
        messagebox.showerror("Error", "Invalid email or password. Please register first.")

# Create the Main Window
root = tk.Tk()
root.title("Registration & Login Form")

# Create a notebook
notebook = tk.Notebook(root)
notebook.pack(pady=10, expand=True)

# Create frames for each tab
register_tab = tk.Frame(notebook)
login_tab = tk.Frame(notebook)

# Add the frames to the notebook
notebook.add(register_tab, text="Register")
notebook.add(login_tab, text="Login")

# Registration Tab
register_title = tk.Label(register_tab, text="Registration Form", font=("Arial", 18))
register_title.grid(row=0, column=0, columnspan=2, padx=10, pady=10)

name_label = tk.Label(register_tab, text="Name:")
name_label.grid(row=1, column=0, padx=5, pady=5)
name_entry = tk.Entry(register_tab, width=30)
name_entry.grid(row=1, column=1, padx=5, pady=5)

email_label = tk.Label(register_tab, text="Email:")
email_label.grid(row=2, column=0, padx=5, pady=5)
email_entry = tk.Entry(register_tab, width=30)
email_entry.grid(row=2, column=1, padx=5, pady=5)

contact_label = tk.Label(register_tab, text="Contact:")
contact_label.grid(row=3, column=0, padx=5, pady=5)
contact_entry = tk.Entry(register_tab, width=30)
contact_entry.grid(row=3, column=1, padx=5, pady=5)

gender_label = tk.Label(register_tab, text="Gender:")
gender_label.grid(row=4, column=0, padx=5, pady=5)
gender_var = tk.StringVar(value=None)
gender_radio1 = tk.Radiobutton(register_tab, text="Male", variable=gender_var, value="Male")
gender_radio1.grid(row=4, column=1, padx=5, pady=5)
gender_radio2 = tk.Radiobutton(register_tab, text="Female", variable=gender_var, value="Female")
gender_radio2.grid(row=5, column=1, padx=5, pady=5)

password_label = tk.Label(register_tab, text="Password:")
password_label.grid(row=6, column=0, padx=5, pady=5)
password_entry = tk.Entry(register_tab, show="*", width=30)
password_entry.grid(row=6, column=1, padx=5, pady=5)

hobbies_label = tk.Label(register_tab, text="Hobbies:")
hobbies_label.grid(row=7, column=0, padx=5, pady=5)
hobbies_listbox = tk.Listbox(register_tab, selectmode=tk.MULTIPLE, width=30)
hobbies_listbox.grid(row=7, column=1, padx=5, pady=5)
hobbies_listbox.insert(tk.END, "Cricket", "