
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='<%= request.getContextPath() %>/resources/fullcalendar.css' rel='stylesheet' />
<link href='<%= request.getContextPath() %>/resources/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='<%= request.getContextPath() %>/resources/lib/moment.min.js'></script>
<script src='<%= request.getContextPath() %>/resources/lib/jquery.min.js'></script>
<script src='<%= request.getContextPath() %>/resources/lib/jquery-ui.custom.min.js'></script>
<script src='<%= request.getContextPath() %>/resources/fullcalendar.min.js'></script>
<script>

	$(document).ready(function() {


		/* initialize the external events
		-----------------------------------------------------------------*/

		$('#external-events .fc-event').each(function() {

			// store data so the calendar knows to render an event upon drop
			$(this).data('event', {
				title: $.trim($(this).text()), // use the element's text as the event title
				stick: true // maintain when user navigates (see docs on the renderEvent method)
			});

			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});

		});


		/* initialize the calendar
		-----------------------------------------------------------------*/

		$('#calendar').fullCalendar({
			
			slotDuration: '00:30:00',
			columnFormat:'dddd',
			header : false,
			allDaySlot : false,
			minTime : "08:00:00",
			maxTime : "18:00:00",
			hiddenDays: [0],
			editable: true,
			droppable: true, // this allows things to be dropped onto the calendar
			drop: function() {
				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}
			},
			defaultView:'agendaWeek'
			
			
		});
		


	});

</script>
<style>

	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
	}
		
	#wrap {
		width: 1100px;
		margin: 0 auto;
	}
		
	#external-events {
		float: left;
		width: 150px;
		padding: 0 10px;
		border: 1px solid #ccc;
		background: #eee;
		text-align: left;
	}
		
	#external-events h4 {
		font-size: 16px;
		margin-top: 0;
		padding-top: 1em;
	}
		
	#external-events .fc-event {
		margin: 10px 0;
		cursor: pointer;
	}
		
	#external-events p {
		margin: 1.5em 0;
		font-size: 11px;
		color: #666;
	}
		
	#external-events p input {
		margin: 0;
		vertical-align: middle;
	}

	#calendar {
		float: right;
		width: 900px;
	}

</style>
</head>
<body>
  
	<div id='wrap'>

		<div id='external-events'>
			<h4>Les cours </h4>
			<c:forEach items="${listCours}" var="cours">
       
            <div class='fc-event'>${cours.libelle}</div>
           
           </c:forEach>
		
		
			<h4>Les Enseignants </h4>
			<c:forEach items="${listEnseignant}" var="ens">
       
            <div class='fc-event'>${ens.nom}</div>
           
           </c:forEach>
		
		
		</div>
     
	 <div id='calendar'></div>

		<div style='clear:both'></div>

	</div>
</body>
</html>
