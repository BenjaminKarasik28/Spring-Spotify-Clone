# Spring-Spotify-Clone

You'll maintain a README file, which will include the following:

# A link to the GitHub repo.
https://github.com/BenjaminKarasik28/Spring-Spotify-Clone


# A list of all your design decisions and the reasons behind each one.
For this assignment, we choose to use a Many-to-Many design between User and Song and a One-to-Many design between User and User_Role. The reason we chose the relationship between Users and Songs to be Many-to-Many, is because each user can share a song. Songs themselves aren't unique to a User so the relationship is described as many Users can have many songs and many Songs can be heard by many Users. The reason we chose the relationship bewteen User and User_Role to be One-to-Many is because a user can only have 1 role, even if theirs a hierarchy in user role authorization. The relationship can be described as many users can have one role and only one role can be assigned to a user. An admin role or DBA role still counts as a user role but with higher authorization.  


# What went right.
Developing the controllers were the easiest part of the assignment. We were able to gain a grasp on how to create and test them by the lessons in class. 


# The challenges you faced.
Some of the challenges we faced were creating the security for the app. There were a lot of tiny errors that were hard to debug because the code we had and the code from the practice lessons where near identical. Some other challenges we faced was during some Git pulls because the code would only work for one of our machines and not both.

# Which part you enjoyed working on the most.
The part we enjoyed the most was testing. We seperatly did mock and stub testing and they were enjoyable. 
