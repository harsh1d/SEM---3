import tkinter as tk
from tkinter import ttk
import sqlite3
import bcrypt
from PIL import Image, ImageTk  # For loading images
import time  # For animation timing
import random  # For random colors

# --- Database Functions ---

def connect_db():
    conn = sqlite3.connect('user_data.db')
    cursor = conn.cursor()
    cursor.execute("""
        CREATE TABLE IF NOT EXISTS users (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            email TEXT UNIQUE,
            contact TEXT,
            gender TEXT,
            password TEXT,
            hobbies TEXT
        )
    """)
    conn.commit()
    conn.close()

# --- Registration Functions ---

def register_user():
    name = name_entry.get()
    email = email_entry.get()
    contact = contact_entry.get()
    gender = gender_var.get()
    password = password_entry.get()
    hobbies = hobbies_var.get()

    if not all([name, email, contact, password]):
        error_label.config(text="Please fill all fields.")
        return

    # Basic email validation
    if not "@" in email or not "." in email:
        error_label.config(text="Please enter a valid email.")
        return

    conn = sqlite3.connect('user_data.db')
    cursor = conn.cursor()

    try:
        # Hash the password before storing it
        hashed_password = bcrypt.hashpw(password.encode(), bcrypt.gensalt())
        cursor.execute(
            "INSERT INTO users (name, email, contact, gender, password, hobbies) VALUES (?, ?, ?, ?, ?, ?)",
            (name, email, contact, gender, hashed_password, hobbies),
        )
        conn.commit()
        error_label.config(text="Registration successful!")
        # ... clear input fields ...
        animate_success_message()  # Animate success message
    except sqlite3.IntegrityError:
        error_label.config(text="Email already exists. Please use a different email.")
    finally:
        conn.close()

# --- Login Functions ---

def login_user():
    email = email_login_entry.get()
    password = password_login_entry.get()

    if not all([email, password]):
        login_error_label.config(text="Please fill all fields.")
        return

    conn = sqlite3.connect('user_data.db')
    cursor = conn.cursor()

    cursor.execute("SELECT password FROM users WHERE email=?", (email,))
    hashed_password_from_db = cursor.fetchone()

    if hashed_password_from_db:
        hashed_password_from_db = hashed_password_from_db[0]
        if bcrypt.checkpw(password.encode(), hashed_password_from_db):
            login_error_label.config(text="Login successful!")
            animate_success_message(login_tab)  # Animate on login tab
            # ... redirect or open new window ...
        else:
            login_error_label.config(text="Invalid email or password.")
    else:
        login_error_label.config(text="User not found.")
    conn.close()

# --- Animation Functions ---

def animate_success_message(parent=register_user):  # Parent frame for animation
    success_message = tk.Label(parent, text="Success!", fg="green", font=("Arial", 16))
    success_message.place(relx=0.5, rely=0.8, anchor="center")
    for i in range(5):
        success_message.config(fg=random.choice(["green", "yellow", "cyan"]))
        parent.update()
        time.sleep(0.2)
    success_message.destroy()

# --- GUI Creation ---

root = tk.Tk()
root.title("Welcome to Our Colorful World!")

# --- Style ---

style = ttk.Style()
style.theme_use('clam')  # Choose a style (clam, default, alt, classic)
style.configure('TButton', background="#007bff", foreground="white", font=("Arial", 12))  # Blue button
style.configure('TLabel', foreground="#4285f4", font=("Arial", 12))  # Blue label
style.configure('TEntry', foreground="black", font=("Arial", 12))  # Black entry text
style.configure('TRadiobutton', background="#f8f9fa", foreground="#4285f4")  # Light gray background for radio buttons

# --- Frames ---

register_tab = tk.Frame(root, bg="#f8f9fa")  # Light gray background
register_tab.pack()

login_tab = tk.Frame(root, bg="#f8f9fa")
#  login_tab.pack()  # Uncomment this to make the login tab visible

# --- Registration Tab ---

name_label = tk.Label(register_tab, text="Name:", bg="#f8f9fa")
name_label.grid(row=0, column=0, padx=5, pady=5)
name_entry = tk.Entry(register_tab)
name_entry.grid(row=0, column=1, padx=5, pady=5)

# ... similar code for email, contact, gender, password, hobbies labels and entries ...

# --- Login Tab ---

# ... similar code for email and password labels and entries ...

# --- Buttons ---

register_button = ttk.Button(register_tab, text="Register", command=register_user)  # Using ttk.Button for style
register_button.grid(row=7, column=0, columnspan=2, padx=5, pady=10)

login_button = ttk.Button(login_tab, text="Login", command=login_user)
login_button.grid(row=2, column=0, columnspan=2, padx=5, pady=10)

# --- Error Labels ---

error_label = tk.Label(register_tab, text="", fg="red", bg="#f8f9fa")
error_label.grid(row=8, column=0, columnspan=2, padx=5, pady=5)

login_error_label = tk.Label(login_tab, text="", fg="red", bg="#f8f9fa")
login_error_label.grid(row=3, column=0, columnspan=2, padx=5, pady=5)

# --- Image ---

image_path = "IMAGE.jpg"  # Replace with the actual path of your image
image = Image.open(image_path)
photo = ImageTk.PhotoImage(image)
image_label = tk.Label(register_tab, image=photo, bg="#f8f9fa")  # Add image to the registration tab
image_label.image = photo  # Keep a reference to prevent garbage collection
image_label.grid(row=9, column=0, columnspan=2)  # Place the image below the form

# --- Database Connection ---

connect_db()

root.mainloop()