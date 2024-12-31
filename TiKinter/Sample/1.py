import tkinter as tk
from tkinter import messagebox

def add_invoice():
    # Function to handle adding an invoice
    def submit_invoice():
        invoice_no = entry_invoice_no.get()
        customer_name = entry_customer_name.get()
        contact_no = entry_contact_no.get()
        invoice_amount = entry_invoice_amount.get()

        # Print the input to the console or process it as needed
        print(f"Invoice No.: {invoice_no}")
        print(f"Customer Name: {customer_name}")
        print(f"Contact No.: {contact_no}")
        print(f"Invoice Amount: {invoice_amount}")

        # Close the input window
        add_window.destroy()

    # Create a new window for adding an invoice
    add_window = tk.Toplevel(root)
    add_window.title("Add Invoice")

    # Invoice No.
    tk.Label(add_window, text="Enter Invoice No.:").pack()
    entry_invoice_no = tk.Entry(add_window)
    entry_invoice_no.pack()

    # Customer Name
    tk.Label(add_window, text="Enter Customer Name:").pack()
    entry_customer_name = tk.Entry(add_window)
    entry_customer_name.pack()

    # Contact No.
    tk.Label(add_window, text="Enter Contact No.:").pack()
    entry_contact_no = tk.Entry(add_window)
    entry_contact_no.pack()

    # Invoice Amount
    tk.Label(add_window, text="Enter Invoice Amount:").pack()
    entry_invoice_amount = tk.Entry(add_window)
    entry_invoice_amount.pack()

    # Submit Button
    tk.Button(add_window, text="Submit", command=submit_invoice).pack()

# Function to handle invalid choices
def invalid_choice():
    messagebox.showerror("Invalid Choice", "Please select a valid menu option.")

# Create the main window
root = tk.Tk()
root.title("Menu Device Program")

# Create and place the buttons
tk.Label(root, text="Menu Device Program").pack()

tk.Button(root, text="1. Add Invoice", command=add_invoice).pack(fill=tk.X)
tk.Button(root, text="2. Display Invoice", command=invalid_choice).pack(fill=tk.X)
tk.Button(root, text="3. Edit Invoice", command=invalid_choice).pack(fill=tk.X)
tk.Button(root, text="4. Search Invoice", command=invalid_choice).pack(fill=tk.X)
tk.Button(root, text="5. Delete Invoice", command=invalid_choice).pack(fill=tk.X)
tk.Button(root, text="6. Exit", command=root.quit).pack(fill=tk.X)

# Start the main event loop
root.mainloop()
