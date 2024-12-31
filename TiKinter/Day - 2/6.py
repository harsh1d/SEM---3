# from tkinter import *
# top = Tk()
# top.geometry("400x500")
# title = Label(top, text = "Registration Form", font = ("Courier",14)).place(x = 40, y = 20)
# name = Label(top, text = "Name").place(x = 30, y = 50)
# email = Label(top, text = "Email").place(x = 30, y = 90)
# password = Label(top, text = "Password").place(x = 30, y = 130)
# e1 = Entry(top).place(x = 95, y = 50)
# e2 = Entry(top).place(x = 95, y = 90)
# e3 = Entry(top,show="*").place(x = 95, y = 130)
# Lb1 = Listbox(top)
# Lb1.place(x = 95, y = 130)
# Lb1.insert(1,"Python")
# Lb1.insert(2,"Perl")
# Lb1.insert(3,"C")
# Lb1.insert(4,"PHP")
# Lb1.insert(5,"JSP")
# Lb1.insert(6,"Ruby")
# Lb1.place(x = 95, y = 160)
# submit = Button(top, text = "Submit", bg = "red", fg = "white", font = ("Courier",10)).place(x = 120, y = 340)   
# top.mainloop()

# # List 

from tkinter import *

def on_submit():
    print(f"Name: {name_var.get()}")
    print(f"Email: {email_var.get()}")
    print(f"Password: {password_var.get()}")
    selected_lang = lang_listbox.curselection()
    if selected_lang:
        print(f"Programming Language: {lang_listbox.get(selected_lang)}")
    else:
        print("No programming language selected")

top = Tk()
top.geometry("400x500")
top.title("Registration Form")

title = Label(top, text="Registration Form", font=("Courier", 14))
title.place(x=100, y=20)

name_label = Label(top, text="Name")
name_label.place(x=30, y=50)
name_var = StringVar()
name_entry = Entry(top, textvariable=name_var)
name_entry.place(x=100, y=50)

email_label = Label(top, text="Email")
email_label.place(x=30, y=90)
email_var = StringVar()
email_entry = Entry(top, textvariable=email_var)
email_entry.place(x=100, y=90)

password_label = Label(top, text="Password")
password_label.place(x=30, y=130)
password_var = StringVar()
password_entry = Entry(top, textvariable=password_var, show="*")
password_entry.place(x=100, y=130)

lang_label = Label(top, text="Language")
lang_label.place(x=30, y=170)
lang_listbox = Listbox(top)
languages = ["Python", "Perl", "C", "PHP", "JSP", "Ruby"]
for language in languages:
    lang_listbox.insert(END, language)
lang_listbox.place(x=100, y=170)

submit_button = Button(top, text="Submit", bg="red", fg="white", font=("Courier", 10), command=on_submit)
submit_button.place(x=150, y=340)

top.mainloop()
