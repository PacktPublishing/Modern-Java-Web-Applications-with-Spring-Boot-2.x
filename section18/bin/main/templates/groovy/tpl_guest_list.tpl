yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        title('Person List')
        link(rel: 'stylesheet', href: '//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css')
        script(src: '//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js'){}
        script(src: '//code.jquery.com/jquery-1.11.1.min.js'){}
    }
    body {
    div ( class: 'container'){
       div ( class : 'row col-md-6 col-md-offset-2 custyle') {
        h2 ('FarmUp Guest List')
         
        table (class : 'table table-striped custab')  {
            thead () {
            	a (href: '#', class: 'btn btn-primary btn-xs pull-right'){
            		span (style='color : #006400') {
            		  yield "Add Guest"
            	   }
            	}
            	tr () {
            		th("ID")
            		th("Username")
            		th("Password")
            		th("Action")
        		}
            
            }
            tbody() {
                users.each { user ->
                tr {
                   td("1")
                   td("$user")
                   td("passwd")
                   td(class:'text-center') {
                      a (class:'btn btn-info btn-xs', href:'#') {
                         span (class:'glyphicon glyphicon-remove'){
                             yield "Del"
                         }
                      }
                   }
                }
            }
            
            }
            
            
            
          }
        }
      }
    }
}