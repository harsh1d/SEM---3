from tkinter import*
from tkinter import messagebox
from PIL import ImageTk
#Creating The Application main Window
top = Tk()

top.title("My First Window")        
top.geometry("500x500")

# Creating A Function
def function():
    print("Function Called")
    messagebox.showinfo("Hello Python","Hello World")
    
#Render Image
img = ImageTk.PhotoImage(file="IMAGE.jpg")

#Creating a Button 
btn = Button(top, image=img,command=function)

btn.pack(side=TOP)

#Entering The Event Main Loop
top.mainloop() # it has to be last line of every code 