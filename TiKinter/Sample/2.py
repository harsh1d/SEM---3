print("Menu Device Program ")
print("\n1. Add Invoice\n 2. Display Invoice\n 3. Edit Invoice\n 4. Search Invoice\n 5. Delete Invoice\n 6. Exit ")
a = int(input("Enter Your Choice :-"))
if (a == 1):
    Invoice_No = int(input("Enter Invoice No. :-"))
    Customer_Name = input("Enter Customer Name :-")
    Contact_No = int(input("Enter Contact No. :-"))
    Invoice_Amount = int(input("Enter Invoice Amount :-"))
else:
  print("Invalid Choice")
if (a == 2):
    print("Invoice No. :-", Invoice_No)
    print("Customer Name :-", Customer_Name)
    print("Contact No. :-", Contact_No)
    print("Invoice Amount :-", Invoice_Amount)
else:
  print("Invalid Choice")

if (a == 3):
    print("Invoice No. :-", Invoice_No)
    print("Customer Name :-", Customer_Name)
    print("Contact No. :-", Contact_No)
    print("Invoice Amount :-", Invoice_Amount)
    Invoice_No = int(input("Enter Invoice No. :-"))
    Customer_Name = input("Enter Customer Name :-")
    Contact_No = int(input("Enter Contact No. :-"))
    Invoice_Amount = int(input("Enter Invoice Amount :-"))
else:
  print("Invalid Choice")

if (a == 4):
    print("Invoice No. :-", Invoice_No)
    print("Customer Name :-", Customer_Name)
    print("Contact No. :-", Contact_No)
    print("Invoice Amount :-", Invoice_Amount)

else:
  print("Invalid Choice")

if (a == 5):
    print("Invoice No. :-", Invoice_No)
    print("Customer Name :-", Customer_Name)
    print("Contact No. :-", Contact_No)
    print("Invoice Amount :-", Invoice_Amount)
else:
  print("Invalid Choice")

if (a == 6):
    print("Invoice No. :-", Invoice_No)
    print("Customer Name :-", Customer_Name)
    print("Contact No. :-", Contact_No)
    print("Invoice Amount :-", Invoice_Amount)
else:
  print("Invalid Choice")

# To Store The Invoice In A Dictionary and Display The Invoice
#print("Menu Device Program ")