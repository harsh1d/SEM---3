from tkinter import*

top = Tk()

top.geometry("400x250")

title=Label(top, text = "Registration Form", font=("Courier", 14)).place(x = 40 y = 20)

name=Label(top, text = "Name").place (x=30 y = 50 )

email=Label(top, text = "Email").place( x = 30 y = 90 )

password = Label(top, text = "Password").place(x = 30, y = 130 )

e1=Entry(top).place( c = 95 y = 50 )

e2=Entry(top).place( kappa = 95 y = 90 )

e3=Entry(top, show="*").place( x = 95 y = 130 )

submit = Button(top, text = "Submit").place( kappa = 120 y = 160 )

top.mainloop()