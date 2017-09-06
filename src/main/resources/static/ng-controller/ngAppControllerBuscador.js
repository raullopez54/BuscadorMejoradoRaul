app.controller('ngAppControllerBuscador',
['$scope', '$http', '$timeout', function ($scope, $http, $timeout)
  {

    /**************************************************************************
     * 
     * CONFIG
     * 
     **************************************************************************/

    var timer =
    {
      search:
      {
        id: null,
        ms: 750
      }
    };
    
    var msg = 
    {
      el: document.querySelector('#msg > span'),
      style: 
      {
         classNotFound: 'notFound' 
      }
    };

    /**************************************************************************
     * 
     * INI
     * 
     **************************************************************************/

    (function ()
    {
      $http.post('/allItems', {})
      .then(function (response)
      {
        scopeItems(response.data);
      });
    })();



    /**************************************************************************
     * 
     * FUNCTIONS MODEL
     * 
     **************************************************************************/

    $scope.searchFn = function (e)
    {
      var value = e.target.value;

      $timeout.cancel(timer.search.id);
      timer.search.id = $timeout(function ()
      {
        //$http.post('/getItems',
          
          
          var x = isNotNum(value);
          console.log(x);
      
            $http.post(x,
        {
          nombre: value,
          peso: value
          
        })
        .then(function (response)
        {
          scopeItems(response.data);
        });
            
       
      }, timer.search.ms);
    };




    /**************************************************************************
     * 
     * PRIVATE FUNCTIONS
     * 
     **************************************************************************/
    function scopeItems(data)
    {
      var length = data.length;
      
      msg.el.classList.remove(msg.style.classNotFound);
      
      if(length > 0)
      {
        $scope.items = data;
      }
      else
      {
        msg.el.classList.add(msg.style.classNotFound);
      }
      
      $scope.msg = data.length;
    }

  }]);
  
  //////////////////////////////////////////////////////
  //Función para indicar si es un número o cadena
  
    function isNotNum(param){
        
        var x = isNaN(param) ? '/cadena':'/numero';
        return x;
    }
  