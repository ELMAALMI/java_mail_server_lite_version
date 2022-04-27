<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div>
	 <div class="container" style="display: flex;justify-content: center;align-content: center">
            <form style="width: 640px;padding: 30px;" action="SendMailServletExc" method="get">
                <div class="form-group">
                    <label class="col-lg-2 control-label">To</label>
                    <div class="col-lg-12">
                        <input type="text" name="to" placeholder="" id="inputEmail1" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Subject</label>
                    <div class="col-lg-12">
                        <input type="text" name="subject" placeholder="" id="inputPassword1" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Message</label>
                    <div class="col-lg-12">
                        <textarea rows="10" cols="30" class="form-control" id="" name="message"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-lg btn-block" type="submit">Send</button>
                </div>
            </form>
        </div></div>
</body>
</html>