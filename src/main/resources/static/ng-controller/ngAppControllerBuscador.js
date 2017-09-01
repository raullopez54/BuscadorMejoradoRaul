app.controller('ngAppControllerBuscador',
['$scope', '$http', '$timeout', function ($scope, $http, $timeout)
  {
    var timer =
    {
      search:
      {
        id: null,
        ms: 750
      }
    };
    
    //PARA QUE SALGAN TODOS LOS ELEMENTOS DEL BBDD
    
    (function ()
    {
      $http.post('/allItems', {})
      .then(function (response)
      {
        var data = response.data;

        $scope.items = data;
      })
    })();

    //PARA QUE SALGAN TODOS LOS ELEMENTOS BUSCADOS DEL BBDD

    $scope.searchFn = function (e)
    {
      var value = e.target.value;

      $timeout.cancel(timer.search.id);
      timer.search.id = $timeout(function ()
      {
        $http.post('/getItems',
        {
          nombre: value
        })
        .then(function (response)
        {
          var data = response.data;
          $scope.items = data;
        });

      }, timer.search.ms);
    };

  }]);