# disposable-archive
A small program that creates a zip archive and allows it to unpack only once. 
When unpacking the password is used. It consists of two parts: the first part of the password entered by user,
and the second part of the password is obtained from the remote service (memcached from Redis Labs). 
After the use, the second part of password is removed from memcached.
