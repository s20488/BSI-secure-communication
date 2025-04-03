# BSI-secure-communication by Anastasiia Ponkratova, Julia Migiel
## Example of a Secure Communication Program Based on the Asymmetric RSA Encryption Algorithm
Using the RSA algorithm, this system provides an encrypted chat method for two users on different devices. The code utilizes socket programming and Java’s built-in libraries for the RSA algorithm. The server is named Eve, and the client is named Adam. The server must be started first, followed by the client. Initially, public keys are exchanged between them. Adam can send a message first, then Eve can respond, and so on. The encrypted message is received, and after confirmation, it can be decrypted and viewed.

#### Launching Testserver
When launched, Adam’s public key is published, and Eve—knowing it—can encrypt a message that only Adam can decrypt using his private key.
![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/Testserver_start.png?raw=true)

#### Launching TestClient
When launched, Eve’s public key is published, and Adam—knowing it—can encrypt a message that only Eve can decrypt using her private key.

![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/TestClient_start.png?raw=true)

#### Sending a Message from TestClient
Let’s write a message for Eve.

![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/TestClient_sending_message.png?raw=true)

#### Receiving a Message on Testserver
The server receives an encrypted message from Adam along with a prompt to decrypt it. After confirmation, the encrypted message is retrieved.

![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/Testserver_receiving_message.png?raw=true)

#### Sending a Message from Testserver
Let’s write a message for Adam.

![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/Testserver_sending_message.png?raw=true)

#### Receiving a Message on TestClient
The client receives an encrypted message from Eve along with a prompt to decrypt it. After confirmation, the encrypted message is retrieved.

![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/TestClient_receiving_message.png?raw=true)
