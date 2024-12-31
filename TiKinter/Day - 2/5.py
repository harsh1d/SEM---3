# # # get Method
# # # Used to get value from user 
# # def login():
# #     username = user.get()
# #     password = code.get()
# #     if username == "admin" and password == "1234":
# #         messagebox.showinfo("Login", "Login Successful")
# #     else:
# #         messagebox.showinfo("Login", "Login Failed")
# # get Method
# # Used to get value from user 
#from tkinter import *
#from tkinter import messagebox
# root = Tk()
# root.title("Login")
# root.geometry("500x500")
# #Syntax for fetching data from user in form of text and Entry Widget
# e1 = e1.get("1.0","end-1c")
# e1.place(X=20,Y=30)
# #  Here 1,0 are equivalent to line.columnnumber where 1 is line number and 0 is column number
# root.mainloop()
import tkinter as tk
from tkinter import ttk

def center_window(window, width, height):
    screen_width = window.winfo_screenwidth()
    screen_height = window.winfo_screenheight()
    x = (screen_width / 2) - (width / 2)
    y = (screen_height / 2) - (height / 2)
    window.geometry(f"{width}x{height}+{int(x)}+{int(y)}")

def display_input():
    user_input = input_entry.get()
    print(f"User Input: {user_input}")
    message_label.config(text=f"You entered: {user_input}")

window = tk.Tk()
window.title("User Input Display")
window.configure(bg="#87CEFA")

# Create a style for the ttk widgets
style = ttk.Style()
style.configure("TFrame", background="#87CEFA")
style.configure("TLabel", background="#87CEFA", font=("Arial", 14))
style.configure("TEntry", font=("Arial", 14))
style.configure("TButton", font=("Arial", 14), background="#1E90FF")

# Title Label
title_label = tk.Label(window, text="Enter Your Input", bg="#87CEFA", font=("Arial", 24, "bold"))
title_label.pack(pady=20)

# Create input frame
input_frame = ttk.Frame(window, padding="20")
input_frame.pack(padx=20, pady=20)

# Input label and entry
input_label = ttk.Label(input_frame, text="Input:")
input_label.grid(row=0, column=0, padx=5, pady=5, sticky="e")
input_entry = ttk.Entry(input_frame, font=("Arial", 14))
input_entry.grid(row=0, column=1, padx=5, pady=5)

# Display button
display_button = ttk.Button(input_frame, text="Display", command=display_input)
display_button.grid(row=1, column=0, columnspan=2, padx=5, pady=20)

# Message label to display the input
message_label = ttk.Label(window, text="", background="#87CEFA", font=("Arial", 14))
message_label.pack(pady=10)

center_window(window, 400, 300)

window.mainloop()
