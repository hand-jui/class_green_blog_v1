
let index = {

	init: function() {
		$("#btn-save").bind("click", () => {
			this.save();
		});
	},
	save: function() {
		// 회원가입
		// console.log("save 함수 실행")
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		// console.log(data);
		$.ajax({
			type: "POST",
			url: "/api/user",
			contentType: "application/json; charset=utf-8;",
			data: JSON.stringify(data),  // HTTP BODY
			dataType: "json"  // 응답시 데이터 타입
		}).done(function(res) {
			console.log(res);
			if (res.status == "OK") {
				alert("회원가입 성공");
				location.href = "/loginPage";
			}
		}).fail();
	}
};

index.init();