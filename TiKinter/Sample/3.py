invoices = {}

def add_invoice():
    invoice_no = int(input("Enter Invoice No. :-"))
    customer_name = input("Enter Customer Name :-")
    contact_no = int(input("Enter Contact No. :-"))
    invoice_amount = int(input("Enter Invoice Amount :-"))
    invoices[invoice_no] = {
        'Customer Name': customer_name,
        'Contact No.': contact_no,
        'Invoice Amount': invoice_amount
    }
    print("Invoice added successfully.")

def display_invoices():
    if not invoices:
        print("No invoices to display.")
    else:
        for invoice_no, details in invoices.items():
            print(f"Invoice No.: {invoice_no}")
            print(f"Customer Name: {details['Customer Name']}")
            print(f"Contact No.: {details['Contact No']}")
            print(f"Invoice Amount: {details['Invoice Amount']}")
            print('---')

def edit_invoice():
    invoice_no = int(input("Enter Invoice No. to edit: "))
    if invoice_no in invoices:
        customer_name = input("Enter new Customer Name :-")
        contact_no = int(input("Enter new Contact No. :-"))
        invoice_amount = int(input("Enter new Invoice Amount :-"))
        invoices[invoice_no] = {
            'Customer Name': customer_name,
            'Contact No': contact_no,
            'Invoice Amount': invoice_amount
        }
        print("Invoice updated successfully.")
    else:
        print("Invoice not found.")

def search_invoice():
    invoice_no = int(input("Enter Invoice No. to search: "))
    if invoice_no in invoices:
        details = invoices[invoice_no]
        print(f"Invoice No.: {invoice_no}")
        print(f"Customer Name: {details['Customer Name']}")
        print(f"Contact No.: {details['Contact No']}")
        print(f"Invoice Amount: {details['Invoice Amount']}")
    else:
        print("Invoice not found.")

def delete_invoice():
    invoice_no = int(input("Enter Invoice No. to delete: "))
    if invoice_no in invoices:
        del invoices[invoice_no]
        print("Invoice deleted successfully.")
    else:
        print("Invoice not found.")

while True:
    print("\nMenu Device Program")
    print("1. Add Invoice")
    print("2. Display Invoice")
    print("3. Edit Invoice")
    print("4. Search Invoice")
    print("5. Delete Invoice")
    print("6. Exit")
    choice = int(input("Enter Your Choice: "))

    if choice == 1:
        add_invoice()
    elif choice == 2:
        display_invoices()
    elif choice == 3:
        edit_invoice()
    elif choice == 4:
        search_invoice()
    elif choice == 5:
        delete_invoice()
    elif choice == 6:
        print("Exiting the program.")
        break
    else:
        print("Invalid Choice")
