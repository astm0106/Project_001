var int_array = [];

// 数字ボタンをクリックすると、その値が配列に格納される
document.addEventListener('DOMContentLoaded',function(){
    var btns = document.querySelectorAll('#int_btn');
    for(var i = 0; i < btns.length; i++){
        btns[i].addEventListener('click',function(){
            console.log(this.innerHTML);
            int_array.push(this.innerHTML);
        },false);
    }
},false);

  // jQuery
  $(function(){
    $('#fin_btn').click(function(event){
      const str1 = $("#name1").val();

      //ユーザー名未入力であれば警告を表示。入力した数字はリセットしない。
      if(!str1){
    	  alert("ユーザー名を入力してください");
      }else{

      var dataSample = {
    		    user_name : str1,
    		    array : int_array
    		  };
    　　　　alert(str1 + "が入力した数値: "+ int_array);

      $.ajax({
        type: "POST",
        url: "tomcat9/searchman/p001_a001",
        data    : JSON.stringify(dataSample),        // リクエストJSON
        dataType: "json",
        async   : true,           // true:非同期(デフォルト), false:同期
      })
      // Ajaxリクエストが成功した場合
      .done(function(data){
        $("#text").html(data);
        int_array = [];
        // window.open('/page003.html', "_blank");
      })

      // Ajaxリクエストが失敗した場合
      .fail(function(XMLHttpRequest, textStatus, errorThrown){
    	  int_array = [];
    	alert(textStatus);
      });
      }
    });
  });