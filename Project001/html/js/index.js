var dataSample = {
    param1 : "param",
    param2 : 12345
  };
var int_array = [];

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
    　　　　alert(int_array);

      $.ajax({
        type: "POST",
        url: "tomcat9/searchman/p001_a001",
        data    : dataSample,        //リクエストJSON
        async   : true,           //true:非同期(デフォルト), false:同期
      })
      // Ajaxリクエストが成功した場合
      .done(function(data){
        $("#text").html(data);
        int_array = [];
        window.open('/page003.html', "_blank");

      })
      // Ajaxリクエストが失敗した場合
      .fail(function(XMLHttpRequest, textStatus, errorThrown){
    	  int_array = [];
    	alert(textStatus);
      });
    });
  });