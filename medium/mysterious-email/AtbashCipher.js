let lookup_table = {
    'A': 'Z', 
    'B': 'Y', 
    'C': 'X', 
    'D': 'W', 
    'E': 'V',
    'F': 'U', 
    'G': 'T', 
    'H': 'S', 
    'I': 'R', 
    'J': 'Q',
    'K': 'P', 
    'L': 'O', 
    'M': 'N', 
    'N': 'M', 
    'O': 'L',
    'P': 'K', 
    'Q': 'J', 
    'R': 'I', 
    'S': 'H', 
    'T': 'G',
    'U': 'F', 
    'V': 'E', 
    'W': 'D', 
    'X': 'C', 
    'Y': 'B', 
    'Z': 'A'
    };
     
function mirror(message) {
    let cipher = '';
    for (let letter of message) {
        if (letter !== ' ') {
        cipher += lookup_table[letter];
        } else {
            cipher += ' ';
        }
    }
    return cipher;
}

function main() {
    var question = prompt("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

    if (question.includes("encrypt")) {
        var plaintext = prompt("Enter the plaintext that you would like to encrypt:")
        println("Encrypting '" + plaintext + "' ...");

        var encryptedText = mirror(plaintext);
        println("Encrypted Text: " + encryptedText);
    } else {
        var ciphertext = prompt("Enter the ciphertext that you would like to decrypt:")
        println("Decrypting '" + ciphertext + "' ...");

        var decryptedText = mirror(ciphertext);
        println("Decrypted Text: " + decryptedText);
    }
}

main();