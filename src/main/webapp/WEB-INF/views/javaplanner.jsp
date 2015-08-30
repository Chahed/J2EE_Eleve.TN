<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
java planner
<div class="planner" id="planner"><%= getPlanner(request) %></div>
<%@ page import="com.dhtmlx.planner.*,com.dhtmlx.planner.data.*" %>
<%!
        String getPlanner (HttpServletRequest request) throws Exception {
        DHXPlanner s = new DHXPlanner("../codebase/", DHXSkin.TERRACE);
        s.setWidth(900);
        s.setInitialDate(2013, 0, 23);
        s.load("/events", DHXDataFormat.JSON);
        s.data.dataprocessor.setURL("/events");
  return s.render();
      }
%>
</body>
</html>
