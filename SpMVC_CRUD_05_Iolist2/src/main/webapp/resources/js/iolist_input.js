$(function() {

	$("#btn-save").click(function(){

		// 유효성검사 1 : 값이 입력되지 않은 항목 거르기
		if($("#io_date").val()== "") {
			alert(" 거래일자를 입력하세요 ")
			$("#io_date").focus()
			return false
		}

		if($(":radio[name='io_inout']:checked").length < 1) {
			alert(" 매입매출을 선택하세요 ")
			$("#io_inout").focus()
			return false
		}
		
		if($("#io_ccode").val() == "") {
			alert(" 거래처를 선택하세요 ")
			$("#comp_name").focus()
			return false;
		}

		if($("#io_pcode").val() == "") {
			alert(" 상품을 선택하세요 ")
			$("#pro_name").focus()
			return false;
		}

		if($("#io_price").val() == "") {
			alert(" 상품단가를 입력하세요 ")
			$("#io_price").focus()
			return false;
		}
		
		if(isNaN( $("#io_price").val() )) {
			alert("단가는 숫자로 입력하세요 ")
			$("#io_price").focus()
			$("#io_price").select()
			return false;
		}

		if($("#io_qty").val() == "") {
			alert(" 수량을 입력하세요 ")
			$("#io_qty").focus()
			return false;
		}
		
		if(isNaN( $("#io_qty").val() )) {
			alert(" 수량은 숫자로 입력하세요 ")
			$("#io_qty").focus()
			$("#io_qty").select()
			return false;
		}

		/*
		 * 합계계산 부분
		 */
		if( !isNaN(  $("#io_price").val() ) && 
				!isNaN(  $("#io_qty").val()   )  ) {

			let io_price = Number( $("#io_price").val() )
			let io_qty = Number( $("#io_qty").val() )
			let io_total = io_price * io_qty
			$("#io_total").val(io_total)
			
		}
		
		// 서버로 데이터 전송
		// $('form').submit()
		// "${rootPath}/iolist/input"
		
		$.ajax({
			url : rootPath + "/iolist/input",
			method : 'POST',
			data : $('form').serialize()
		})
		.done(function(result){
			$("#iolist_view").html(result)
		})

		// jQ 3.0 이상에서
		/*
		$.post(rootPath + '/iolist/input',
				{'iolist': $('form').serialize()},
				function(result){
					$("#iolist").html(result)
				}
		)
		*/
		
		
		
		
		
		
		
/*		$("#io_price").keypress(function(event){
			
			alert(event.keyCode)
			
			//if( !isNaN(  $("#io_price").val() ) && 
			//	!isNaN(  $("#io_qty").val()   )  ) {
				
				let io_price = Number(  $("#io_price").val()  )
				let io_qty = Number(   $("#io_qty").val()  )
				let io_total = io_price * io_qty
				
				$("#io_total").val(io_total)
			//}
		})
*/
/*		$("#io_qty").keypress(function(event){
			
			if( !isNaN(  $("#io_price").val() )&& 
				!isNaN(  $("#io_qty").val()   )  ) {
				
				let io_price = number(  $("#io_price").val()  )
				let io_qty = number(   $("#io_qty").val()  )
				let io_total = io_price * io_qty
				
				$("#io_total").val(io_total)
			}
		})
*/
		
		
		
	})
	
	
	
})
