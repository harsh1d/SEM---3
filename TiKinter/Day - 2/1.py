# # To develop in app one lable at center and say login ,next one lable which say user name below login ,beside label on right hand side there will be text box and below it a button of login where it should click message box should appered as Login sucessfull
# from tkinter import *
# from tkinter import messagebox
# import tkinter as tk
# root = tk.Tk()
# root.geometry("500x500")
# root.title("Login")
# root.configure(bg="Blue")
# def login():
#   if username.get() == "admin" and password.get() == "admin":
#     messagebox.showinfo("Login","Login sucessfull")
#   else:
#     messagebox.showinfo("Login","Login failed")
# username = StringVar()
# password = StringVar()
# label1 = Label(root,text="Login",bg="white",font=("Arial",20))
# label1.place(x=210,y=20)
# label2 = Label(root,text="Username",bg="white",font=("Arial",20))
# label2.place(x=70,y=100)
# label3 = Label(root,text="Password",bg="white",font=("Arial",20))
# label3.place(x=70,y=150)
# entry1 = Entry(root,textvariable = username,font=("Arial",20))
# entry1.place(x=210,y=100)
# entry2 = Entry(root,textvariable = password,font=("Arial",20),show="*")
# entry2.place(x=210,y=150)
# button1 = Button(root,text="Login",bg="white",font=("Arial",20),command=login)
# button1.place(x=200,y=200)
# root.mainloop()

from tkinter import *
from tkinter import messagebox

# Create the main application window
root = Tk()
root.geometry("500x300")
root.title("Login")
root.configure(bg="Blue")

# Function to handle login button click
def login():
    if username.get() == "admin" and password.get() == "admin":
        messagebox.showinfo("Login", "Login successful")
    else:
        messagebox.showinfo("Login", "Login failed")

# String variables to store username and password
username = StringVar()
password = StringVar()

# Create and place the "Login" label at the center top
label1 = Label(root, text="Login", bg="white", font=("Arial", 20))
label1.place(relx=0.5, y=30, anchor=CENTER)

# Create and place the "Username" label and entry
label2 = Label(root, text="Username", bg="white", font=("Arial", 16))
label2.place(x=70, y=100)
entry1 = Entry(root, textvariable=username, font=("Arial", 16))
entry1.place(x=210, y=100)

# Create and place the "Password" label and entry
label3 = Label(root, text="Password", bg="white", font=("Arial", 16))
label3.place(x=70, y=150)
entry2 = Entry(root, textvariable=password, font=("Arial", 16), show="*")
entry2.place(x=210, y=150)

# Create and place the "Login" button
button1 = Button(root, text="Login", bg="white", font=("Arial", 16), command=login)
button1.place(relx=0.5, y=220, anchor=CENTER)

# Start the Tkinter event loop
root.mainloop()
