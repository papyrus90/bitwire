<div id="header-menu" class="navbar navbar-default " role="navigation">
    <div class="container-fluid container-fluid-home container-bg">
        <div class="navbar-header"><a class="navbar-brand" href="index.php"><img src="images/logo.png"></a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="products.php">Products</a></li>
                <li><a href="pricing.php">Pricing</a></li>
                <li id="login_form"><a href="javascript:void(0);">Login</a></li>
            </ul>
        </div>
    </div>
</div>

<!--Login form-->
  <!-- Modal -->
<div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">    
      <!-- Modal content login form-->
            <div class="modal-content">
                <div class="modal-header" style="padding:35px 50px;">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4><span class="glyphicon glyphicon-lock"></span> Sign in with email</h4>
                    <!-- <h5>Lorem ipsum dolor sit amet lorem ipsum dolor sit amet</h5> -->
                </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form">
                        <div class="form-group">
                            <!--<label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>-->
                            <input type="email" class="form-control" id="usrname" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <!-- <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> -->
                            <input type="password" class="form-control" id="psw" placeholder="Enter password">
                        </div>
                        <div class="checkbox">
                            <label><input type="checkbox" value="" checked>Keep me signed in</label>
                        </div>
                            <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Sign in</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Register</button>
                    <p>Not a member? <a href="#" id="register_form">Sign Up</a></p>
                    <p>Forgot <a href="#">Password?</a></p>
                </div>
            </div>
        </div>
    </div> 
</div>
<!-- Register form -->
<div class="modal fade" id="registerModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content register form-->
        <div class="modal-content">
            <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span> Register with email</h4>
            </div>
                <div class="modal-body" style="padding:40px 50px;">
                    <form role="form">
                        <div class="form-group">
                            <!--<label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>-->
                            <input type="email" class="form-control" id="fullname" placeholder="Full name">
                        </div>
                        <div class="form-group">
                            <!--<label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>-->
                            <input type="email" class="form-control" id="email" placeholder="Email address">
                        </div>
                        <div class="form-group">
                        <!-- <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> -->
                        <input type="password" class="form-control" id="psw" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <!-- <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> -->
                            <input type="password" class="form-control" id="psw-confirm" placeholder="Confirm password">
                        </div>
                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Register</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                </div>
            </div>
        </div>
    </div> 
</div>

<script>
// Calling login form
$(document).ready(function(){
    $("#login_form").click(function(){
        $("#loginModal").modal('show');
        $("#registerModal").modal('hide');
        return false;
    });
});

// Calling register form
$(document).ready(function(){
    $("#register_form").click(function(){
        $("#registerModal").modal('show');
        $("#loginModal").modal('hide');
        return false;
    });
});
</script>
