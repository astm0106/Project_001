  // jQuery
  $(function(){
    $("#button").click(function(event){
      $.ajax({
        type: "GET",
        url: "txt/get_message.txt",
        dataType : "text"
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
