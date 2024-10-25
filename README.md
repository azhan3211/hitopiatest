# hitopiatest

# Test Problem Solving Answer
You can check in
app -> src -> main -> java/com/test/hitopia -> function

# how to run

clone this repository and run it in android studio.

here is the application that will appear if the run is successful

<img src="https://github.com/user-attachments/assets/8112d355-077b-4ce9-ad92-a39f19befdaa" alt="Screenshot" height="800">


================================================================================

# Explanation about Problem Solving Test Number 2

# Time Complexity:

1. Loop through formattedInput: This operation iterates through all characters in the input string, making it O(n) where n is the length of input.
2. Stack Operations (push/pop): Each operation with the stack (add or removeLast) is O(1) since they operate at the end of the deque.
3. Since every character is processed once with a constant-time stack operation, the overall time complexity is O(n).

# Space Complexity:

Stack: In the worst case, if all characters are opening brackets (e.g., "(({{[["), the stack will hold n/2 characters, resulting in O(n) space complexity.
