function encrypt(plaintext) {
    let ciphertext = "";
    for (let i = 0; i < plaintext.length(); i++) {
        let char = plaintext[i];
        if (char.toUpperCase(plaintext[i])) {
            let ch = String.fromCharCode((char.charCodeAt(0) + 13 - 65) % 26 + 65);
            ciphertext += ch;
        } else {
            let ch = String.fromCharCode((char.charCodeAt(0) + 13 - 97) % 26 + 97);
            ciphertext += ch;
        }
    }
    return result;
}
function decrypt(ciphertext) {
    let plaintext = "";
    for (let i = 0; i < ciphertext.length(); i++) {
        let char = ciphertext[i];
        if (char.toUpperCase(ciphertext[i])) {
            let ch = String.fromCharCode((char.charCodeAt(0) - 13 - 65 + 26) % 26 + 65);
            plaintext += ch;
        } else {
            let ch = String.fromCharCode((char.charCodeAt(0) - 13 - 97 + 26) % 26 + 97);
            plaintext += ch;
        }
    }
    return plaintext;
}

function main() {
    var question = prompt("Do you want to encrypt or decrypt text? (encrypt/decrypt)");

    if (question.includes("encrypt")) {
        var plaintext = prompt("Enter the plaintext that you would like to encrypt:");
        
        println("Encrypting '" + plaintext + "' ...");
        
        var encryptedText = encrypt(plaintext);
        println("Encrypted Text: " + encryptedText);
    } else {
        var ciphertext = prompt("Enter the ciphertext that you would like to decrypt:");
        println("Decrypting '" + ciphertext + "' ...");

        var decryptedText = decrypt(ciphertext);
        println("Decrypted Text: " + decryptedText);
        
    }
}

main();