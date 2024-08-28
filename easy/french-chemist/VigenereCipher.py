# not finished

def generateKey(str, key):
    key = list(key)
    if len(str) == len(key):
        return key
    else:
        for i in range(len(str) - len(key)):
            key.append(key[i % len(key)])
    return "".join(key)