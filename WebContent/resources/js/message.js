 $(document).ready(function(){
	window.onscroll = function() {
		myFunction()
	};
	var navbar = document.getElementById("page_header");
	var sticky = navbar.offsetTop;

	function myFunction() {
		if (window.pageYOffset > sticky) {
			navbar.classList.add("stickey");
		} else {
		    navbar.classList.remove("stickey");
		}
	}
 	$('#see_table_id').click(function(){
 		console.log('Displaying all messages in table');
 		$.ajax({
 			url:'message',
 			type:'GET',
 			datatype:'json',
 			success: function(responseData){
 				console.log(responseData);
 				$("#row_head").show();
 				$('tr.allMessage').remove();
 				$("#add_button").removeAttr("disabled");
 				var jsonObject = JSON.parse(responseData);
 				if (jsonObject) {
 					var len = jsonObject.length;
					var txt = "";
					if (len > 0) {
						$('tr.allMessage').remove();
						for (var i = 0; i <len; i++) {
							if (jsonObject[i].name && jsonObject[i].message) {
								txt += '<tr id="tr"'+jsonObject[i].id+'" class="allMessage">'
									+ '<td class="name">' + jsonObject[i].name 
									+ '</td><td class="message">' + jsonObject[i].message 
									+ '</td><td><img src="http://www.sharmatransports.com/images/close.jpg" width="35" height="35" style=" border-radius: 50%;cursor: pointer;" '
									+ ' onclick="deleteByImage(this)" id="'+jsonObject[i].id+'"></td></tr>';
							}
						}
						if (txt != ""){
							$("#table").append(txt);
						}
					}
				} 
 			},
 			error: function(jqXHR, textStatus, errorThrown) {
 				alert('errors:  ' + textStatus + ': ' + errorThrown);
 			}
 		});
 	});			
 });
 function deleteByImage(elem){
 	var myid = $(elem).attr("id");
	$.ajax({
		url:'delete',
		type:'POST',
		data: {
			id:myid
		},
		success:function(response){
			$(elem).parent('td').parent('tr').remove();
			console.log('deletion performed');
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert('errors:  ' + textStatus + ': ' + errorThrown);
		}
	});
 }
 function addMessage(){
	 var myname = $('#name').val();
	 var mymessage = $('#message').val();
	 document.getElementById("name").value="";
	 document.getElementById("message").value="";
	 $.ajax({
		url:'save',
 		type:'POST',
 		data:{
 			name: myname,
 			message:mymessage
 		},
 		success:function(responseData){
 			console.log('add in the success');
			var jsonObject = JSON.parse(responseData);
			if (jsonObject) {
				var len = jsonObject.length;
				var row = "";
				if (len > 0){
					var i = len-1;
					if (jsonObject[i].name && jsonObject[i].message) {
						row += '<tr id="tr"'+jsonObject[i].id+'" class="allMessage"><td class="name">' + jsonObject[i].name 
							+ '</td><td class="message">' + jsonObject[i].message + '</td>'
							+ '<td><img src="http://www.sharmatransports.com/images/close.jpg" width="35" height="35"  style=" border-radius: 50%;cursor: pointer; ' 
							+ ' onclick="deleteByImage(this)" id="'+jsonObject[i].id+'"></td></tr>';
					}
					if (row != ""){
						$("#table").append(row);
						console.log('Message Added');
					}
					else{
						console.log('No data found');
					}					
				}
			}
 		},
 		error: function(jqXHR, textStatus, errorThrown) {
 			alert('Message not added due to errors:  ' + textStatus + ': ' + errorThrown);
		}
 	});
 }
 