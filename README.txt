There are 4 HTML 5 valid web pages:
1. /user/login - Login form for the user
2. /user/register - Form for new user registration
3. /message/add - Form for adding message
4. /message/list - List of messages

We used Spring and Hibernate frameworks, Java, JSP, MySQL workbench, and Eclipse IDE for this homework.

Spring Security takes care of the user login authentication, logout, and access control of the pages. Only authenticated users can access /message/list and /message/add pages.

Knock sequence is calculated when the users logs in, by taking MD5 hash of the username, and modulo 4 of the first 4 characters of the hash.

Once the logged in user performs this knock sequence, the user enters a secret mode. Only secret messages are displayed on /message/list page in secret mode. On adding messages via /message/add page in secret mode, the messages are stored as secret messages and they cannot be viewed in normal mode.

Once the user logs out, or logs in as a different user, the secret mode is disabled.

We have used ngrok to get a publicly routable URL to our local machine (http://localhost:8080).

Source code and MySql dumpfile has been attached.

