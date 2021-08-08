const dataSample = {
    param1 : "param",
    param2 : 12345
  };

  // jQuery
  $(function(){
    $('#fin_btn').click(function(event){
      $.ajax({
        type: "POST",
        url: "tomcat9/searchman/p001_a001",
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