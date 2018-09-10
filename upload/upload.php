<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		$image = $_POST['image'];
                $name = $_POST['name'];
		
	define('DB_USERNAME', 'root');
define('DB_PASSWORD', '');
define('DB_HOST', 'localhost');
define('DB_NAME', 'imageupload');
		
		$conn = new mysqli(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);
		
		$path = "uploads/$name.png";
		
		$actualpath = "http://192.168.0.103/$path";
		
		$sql = "INSERT INTO images (photo,name) VALUES ('$actualpath','$name')";
		
		if(mysqli_query($conn,$sql)){
			file_put_contents($path,base64_decode($image));
			echo "Successfully Uploaded";
		}
		
		mysqli_close($conn);
	}else{
		echo "Error";
	}