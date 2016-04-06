app.controller('MainController', ['$scope', function($scope) { 
  $scope.title = '// impossiblearn'; 
  $scope.myself = {
   name: 'Michal',
   birthdate: new Date('1987', '3', '10'),
   bio: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque consequat pharetra massa commodo adipiscing. Nulla vulputate auctor est eu pretium. Maecenas accumsan varius adipiscing. Nunc suscipit sem in dui tempus interdum. Nullam quis suscipit nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed rhoncus eros vitae ante scelerisque sed convallis leo porttitor.',
  };


  $scope.links = {
    git:'https://github.com/michaltrzesimiech',
    linkedin:'https://uk.linkedin.com/in/trzesimiech',
    facebook:'',
  };

  $scope.footer = '(c) the Internet <a href=mailto:michal.trzesimiech@gmail.com>contact</a>';

  $scope.book = {
    cover: 'http://png.clipart.me/graphics/thumbs/157/blank-book-cover-on-white-background-vector-illustration_157014239.jpg',
  };
  
  $scope.linkModelFunc = function (url){
    console.log('link model function');
    $window.open(url);
  }
  
}]);
