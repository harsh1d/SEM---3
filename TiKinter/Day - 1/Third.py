# create a program that will use all the options such as ANCHOR ,bg ,bd,front,fg.. for labels using tkinter
from tkinter import*
from tkinter import messagebox
window=Tk()
window.title("Hello world")
window.geometry("300x300")
window.config(bg="blue")
label1=Label(window,text="Hello world",bg="red",fg="white",font=("Arial",20,"bold") )
label1.pack()

def function():
    print("Function Called")
    messagebox.showinfo("Hello Python","Hello World")   

btn = Button(window, text="Login",command=function)
btn.pack(side=TOP)

window.mainloop()
