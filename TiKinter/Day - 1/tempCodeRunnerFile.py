# Cafe Management System using Tkinter

from tkinter import *
from tkinter import messagebox
from tkinter import ttk

class CafeManagementSystem:
    def __init__(self, root):
        self.root = root
        self.root.title("Cafe Management System")
        self.root.geometry("800x600")
        self.root.configure(bg="white")

        # Create frames
        self.menu_frame = Frame(self.root, bg="white")
        self.menu_frame.pack(side=LEFT, padx=10, pady=10)

        self.order_frame = Frame(self.root, bg="white")
        self.order_frame.pack(side=RIGHT, padx=10, pady=10)

        self.bill_frame = Frame(self.root, bg="white")
        self.bill_frame.pack(side=BOTTOM, padx=10, pady=10)

        self.payment_frame = Frame(self.root, bg="white")
        self.payment_frame.pack(side=BOTTOM, padx=10, pady=10)

        self.customer_frame = Frame(self.root, bg="white")
        self.customer_frame.pack(side=BOTTOM, padx=10, pady=10)

        # Menu frame
        self.menu_label = Label(self.menu_frame, text="Menu", font=("Arial", 16))
        self.menu_label.pack()

        self.menu_listbox = Listbox(self.menu_frame, width=30)
        self.menu_listbox.pack(pady=10)

        self.add_menu_button = Button(self.menu_frame, text="Add Menu Item", command=self.add_menu_item)
        self.add_menu_button.pack()

        # Order frame
        self.order_label = Label(self.order_frame, text="Order", font=("Arial", 16))
        self.order_label.pack()

        self.order_listbox = Listbox(self.order_frame, width=30)
        self.order_listbox.pack(pady=10)

        self.add_order_button = Button(self.order_frame, text="Add Order", command=self.add_order)
        self.add_order_button.pack()

        # Bill frame
        self.bill_label = Label(self.bill_frame, text="Bill", font=("Arial", 16))
        self.bill_label.pack()

        self.bill_text = Text(self.bill_frame, width=40, height=10)
        self.bill_text.pack(pady=10)

        # Payment frame
        self.payment_label = Label(self.payment_frame, text="Payment", font=("Arial", 16))
        self.payment_label.pack()

        self.payment_entry = Entry(self.payment_frame, width=20)
        self.payment_entry.pack(pady=10)

        self.pay_button = Button(self.payment_frame, text="Pay", command=self.pay)
        self.pay_button.pack()

        # Customer frame
        self.customer_label = Label(self.customer_frame, text="Customer", font=("Arial", 16))
        self.customer_label.pack()

        self.customer_entry = Entry(self.customer_frame, width=20)
        self.customer_entry.pack(pady=10)

        self.save_customer_button = Button(self.customer_frame, text="Save Customer", command=self.save_customer)
        self.save_customer_button.pack()

    def add_menu_item(self):
        menu_item = simpledialog.askstring("Add Menu Item", "Enter menu item name")
        if menu_item:
            self.menu_listbox.insert(END, menu_item)

    def add_order(self):
        order = simpledialog.askstring("Add Order", "Enter order details")
        if order:
            self.order_listbox.insert(END, order)

    def pay(self):
        payment = self.payment_entry.get()
        if payment:
            self.bill_text.insert(END, f"Payment: {payment}\n")
            self.payment_entry.delete(0, END)

    def save_customer(self):
        customer = self.customer_entry.get()
        if customer:
            self.bill_text.insert(END, f"Customer: {customer}\n")
            self.customer_entry.delete(0, END)

if __name__ == "__main__":
    root = Tk()
    app = CafeManagementSystem(root)
    root.mainloop()