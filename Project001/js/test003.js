var dataSample = {
    param1 : "param",
    param2 : 12345
  };

  // jQuery
  $(function(){
    $("#button").click(function(event){
      $.ajax({
        type: "GET",
        url: "tomcat9/searchman/servlet/hello",
        data    : dataSample,        //リクエストJSON
        async   : true,           //true:非同期(デフォルト), false:同期
      })
      // Ajaxリクエストが成功した場合
      .done(function(data){
        $("#text").html(data);
      })
      // Ajaxリクエストが失敗した場合
      .fail(function(XMLHttpRequest, textStatus, errorThrown){
        alert(errorThrown);
      });
    });
  });