#  write a python code for reversing a string 
input_string = "hello"
reversed_string = ""

# Iterate over the string in reverse order
for char in input_string:
    reversed_string = char + reversed_string

print(f"Original string: {input_string}")
print(f"Reversed string: {reversed_string}")


# write a python code for swapping two variables 

x = 5
y = 10

# Use a temporary variable to swap the values

temp = x
x = y
y = temp

print(f"After swapping: {x}, {y}")

