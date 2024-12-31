# # To develop in app one lable at center and say login ,next one lable which say user name below login ,beside label on right hand side there will be text box and below it a button of login where it should click message box should appered as Login sucessfull
# # Convert into tablular Formate
# # Use Grid Method 
# from tkinter import *
# from tkinter import messagebox
# import tkinter as tk

# # ipadx,ipady = Padding
# # padx,pady = Margin

## Use of Grid ##
from tkinter import*
parent = Tk()
parent.geometry("250x250")
name = Label(parent,text = "Name").grid(row = 0, column = 0)
e1 = Entry(parent).grid(row = 0, column = 1)
password = Label(parent,text = "Password").grid(row = 1, column = 0)
submit=Button(parent,text ="Submit").grid(row = 4, column = 0, columnspan = 2)
parent.mainloop()