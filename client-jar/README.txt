RMI Client Instructions
=======================

This package contains the necessary files to connect to the RMI server.

Files included:
- LTPTJava_GiaVanVa_HK2-2024-2025-1.0-SNAPSHOT.jar: The JAR file containing all the necessary classes
- rmi.policy: The security policy file for RMI

To run the RMI client:
1. Make sure the RMI server is running
2. Run the client using the following command:
   java -Djava.security.policy=rmi.policy -cp LTPTJava_GiaVanVa_HK2-2024-2025-1.0-SNAPSHOT.jar iuh.fit.rmi.RMIClientMenu

Note: If you encounter any serialization issues, please contact the server administrator for an updated JAR file.
