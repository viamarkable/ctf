Hello! Welcome to my collection of CTF (Capture The Flag) style challenges, focused on cryptography puzzles.

From my novice experience in solving crypto CTFs, I've been inspired to create a few of my own. 
Here's a small (but growing!) collection of some challenges in varying difficulties.

Here's how this works:
    - There are three challenge categories: easy, medium, and hard
    - In each category you will find a folder with the title of the challenge. Clicking into the folder will reveal several files:
        - One prompt file, with the naming convention: "[abbreviated title of challenge]_prompt.rtf"
            This prompt file contains the basic storyline of the challenge, and can contain helpful clues.
        - (Possibly), one image file
            This image file will contain supplementary material to the prompt as needed.
        - One answer folder, in which you will find:
            - One writeup file, with the naming convention: "[abbreviated title of challenge]_writeup.rtf"
                This writeup file contains the deducing method for the challenge, and depending on the challenge, may be very simple (simple shifts, solved by code, etc.) or a more detailed walkthrough (more math-y challenges).
            - One code file, with the naming convention of the cipher type in camelCase
                This code file is essentially, the culmination of this project. Here is where you can find working code to solve this cipher, or any given cipher, as long as you can provide the necessary user parameters. Depending on the cipher, you may also brute force an answer, and when possible/realistic, the code should support this.

Currently, this whole project is hosted on GitHub, but I do have plans for future expansion. I am hoping to move this collection of puzzles into a website, where users can access the cryptography puzzles and cipher solvers separately. Additionally, I plan on writing all the code in several different languages, so users are able to pick whichever they would like and replicate it on their own local devices. All the code will be opensourced on this repository, and it will stay like this for the public to access!

As a disclaimer, I am neither a pro cryptographer nor a pro coder, so this project is also a space for me to learn a lot about ciphers and (especially) coding solutions to said ciphers. This being said, please let me know if I've make a mistake anywhere and I'll do my best to resolve it as soon as possible.

Thank you for participating in this project! I hope you enjoy the games.


ADD ON README.md FOR ARCADE:

How to run the code projects: 
I currently do not have a site to host the code/cipher solvers, so right now, here are the steps you'll need to take to use them.

First, open up a code editor like VSCode (which is what I'll be using).

Create a file with the code that you want to run, or clone it from this repository.

Then, run/debug the code, and answer its questions to use the cipher solver.

Here's an example:

For the CaesarCipher.java file, here's what I would do to run it.

After opening it up, click 'run' as shown here:
<img width="415" alt="image" src="https://github.com/user-attachments/assets/ad28cc68-6259-4773-8917-8ca99601fb3a">
Then, to encrypt my text "helloworld" with a shift of 3, here's what I would input in the terminal:
<img width="411" alt="image" src="https://github.com/user-attachments/assets/75bd76d8-c045-4051-adb2-2141a25efbc3">
To decrypt my text, here's an example:
<img width="406" alt="image" src="https://github.com/user-attachments/assets/d5118102-74db-4cc4-9797-5ed9215fa955">
Or, if I wanted to use the special brute force function, here's what I would do:
<img width="408" alt="image" src="https://github.com/user-attachments/assets/665e9308-d684-4d75-9a26-3bc45bdc0c10">
