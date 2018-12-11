

<!DOCTYPE html>
<html>
<body>
  
 <h2>
I used the following technology:
 </h2>
 <li>Spring RESTful</li>
 <li>Angular</li>



For run application first:
<a href="https://github.com/x-team/daw-purchases/archive/master.zip" target="_blank"><strong>Download project</strong></a> on your machine, unziped...!<br>
 
 <br>
<h4> Install and start the server</h4>
<ul>
  <li>install</li>
  <li>npm start</li>        
                 
  <h2>  Java exam</h2>
  
                                           
                                           

<strong>Overview </strong><br>
For this exam you will be building a backend for a new feature of the Discount Ascii Warehouse ecommerce platform.
Your application will produce a list of "Popular purchases", so customers can see who else bought the same products as them. 
To complete the exam your application will need to accept HTTP requests to /api/recent_purchases/:username and respond with a list of recently purchased products, and the names of other users who recently purchased them.

There is no frontend component to this exam, you're just building the backend.

<strong>Other requirements</strong>

<li>your application must cache API requests so that it can respond as quickly as possible.</li>

<li>	if a username is provided that cannot be found, the API should respond with "User with username of '{{username}}' was not found"</li>


<strong>Where does the data come from?</strong>

Data about users, products and purchases is available to you via an API you can set up and host locally: 
https://github.com/x-team/daw-purchases/blob/master/README.md#api-reference

To work out the "Popular purchases":

<li>fetch 5 recent purchases for the user: GET /api/purchases/by_user/:username?limit=5</li>

<li>for each of those products, get a list of all people who previously purchased that product: GET /api/purchases/by_product/:product_id</li>

<li>	at the same time, request info about the products: GET /api/products/:product_id</li>

<li>	finally, put all of the data together and sort it so that the product with the highest number of recent purchases is first.</li>
Example response:
[
  {
    "id": 555622,
    "face": "｡◕‿◕｡",
    "price": 1100,
    "size": 27,



    "recent": [
      "Frannie79",
      "Barney_Bins18",
      "Hortense6",
      "Melvina84"
    ]
  },
  ...
]

 
 
</body>
</html>
