<script src="../script/jquery-1.3.2.min.js"></script>
<script src="../script/jquery.blockUI.js"></script>

safari 2
<script>
   function bloqueia(){
      jQuery.blockUI({ message: jQuery('#messagewait'), css: { width: '300px' } });		  
   }
</script>

<input type=""button" value="teste" onclick="bloqueia()" />

<br>
<br>
<a href="#" onclick="history.go(-1);">Voltar</a>


   <div id="messagewait" style="display:none; cursor: default; font-size: 14px;">
      <img src="../img/ajaxloadingbar.gif" />
      <br>
      Por favor, aguarde...
   </div>
   






