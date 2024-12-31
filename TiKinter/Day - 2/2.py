import tkinter as tk
from tkinter import ttk
from tkinter import messagebox

def center_window(window, width, height):
    screen_width = window.winfo_screenwidth()
    screen_height = window.winfo_screenheight()
    x = (screen_width / 2) - (width / 2)
    y = (screen_height / 2) - (height / 2)
    window.geometry(f"{width}x{height}+{int(x)}+{int(y)}")

def login():
    if username_entry.get() == "admin" and password_entry.get() == "admin":
        messagebox.showinfo("Login", "Login successful")
    else:
        messagebox.showinfo("Login", "Login failed")

window = tk.Tk()
window.title("Login")
window.configure(bg="#87CEFA")

# Create a style for the ttk widgets
style = ttk.Style()
style.configure("TFrame", background="#87CEFA")
style.configure("TLabel", background="#87CEFA", font=("Arial", 14))
style.configure("TEntry", font=("Arial", 14))
style.configure("TButton", font=("Arial", 14), background="#1E90FF")

# Title Label
title_label = tk.Label(window, text="Login", bg="#87CEFA", font=("Arial", 24, "bold"))
title_label.pack(pady=20)

# Create login frame
login_frame = ttk.Frame(window, padding="20")
login_frame.pack(padx=20, pady=20)

# Username label and entry
username_label = ttk.Label(login_frame, text="Username:")
username_label.grid(row=0, column=0, padx=5, pady=5, sticky="e")
username_entry = ttk.Entry(login_frame, font=("Arial", 14))
username_entry.grid(row=0, column=1, padx=5, pady=5)

# Password label and entry
password_label = ttk.Label(login_frame, text="Password:")
password_label.grid(row=1, column=0, padx=5, pady=5, sticky="e")
password_entry = ttk.Entry(login_frame, show="*", font=("Arial", 14))
password_entry.grid(row=1, column=1, padx=5, pady=5)

# Login button
login_button = ttk.Button(login_frame, text="Login", command=login)
login_button.grid(row=2, column=0, columnspan=2, padx=5, pady=20)

center_window(window, 400, 300)

window.mainloop()
