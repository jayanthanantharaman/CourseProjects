<!DOCTYPE html> 
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" >

<link rel="stylesheet" type="text/css" href="./css/t.css">
 
<style>
		table {
		  border: 1px solid #666;   
			width: 100%;
		}
		th {
		  background: #f8f8f8; 
		  font-weight: bold;    
			padding: 2px;
		}
</style>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
		$(document).ready(function(){
			$('#searchBtn').click(function(){
			var qryTxt = $("#searchQuery").val();
			formData =  {'query': qryTxt};
			$.ajax({
			    url : "api/retrievedocs",
			    type: "POST",
			    data : formData,
			    Accept : 'application/json',
			    success: function(data, textStatus, jqXHR)
			    {
			    	drawTable(data);
			    }
			});
			});
			$('#clear').click(function(){
				$('#searchForm').trigger("reset");
				var table = document.getElementById('dataTable');
				while(table.childNodes.length>2){table.removeChild(table.lastChild);}
			});
		});
		
		function drawTable(data) {
			var records = data.records;
			 $( "#totalHits" ).val( data.totalHits );
			for (var i = 0; i < records.length; i++) {
				drawRow(records[i]);
			}
		}

		function drawRow(rowData) {
			var row = $("<tr/>")
			$("#dataTable").append(row);
			row.append($("<td>" + rowData.id + "</td>"));
			row.append($("<td>" + rowData.title + "</td>"));
			row.append($("<td>" + rowData.author + "</td>"));
		}
	</script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				Information Retrieval
			</h3>
			<form class="form-horizontal" role="form" id="searchForm">
				<div class="form-group">
					 
					<label for="inputEmail3" class="col-sm-2 control-label">
						Query
					</label>
					<div class="col-sm-10">
						<textarea rows="4" cols="80" name="searchQuery" id="searchQuery"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <input type="button" id="searchBtn" name="query" class="btn btn-default" value="Search" />
						 <input type="button" id="clear" name="clear" class="btn btn-default" value="Clear" />
					</div>
					<div class="col-sm-offset-2 col-sm-10">
						 
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">
						Total Hits:
					</label>
					<div class="col-sm-10">
						<input type="text" name="totalHits" id="totalHits" ></input>
					</div>
				</div>
			</form>
			<div class="row">
					<table class="table table-bordered" id="dataTable">
						<thead>
							<tr>
								<th>ID</th>
								<th>Title</th>
								<th>Author</th>
							</tr>
						</thead>
					</table>
				</div>
		</div>
	</div>
</div>
</body>
</html>