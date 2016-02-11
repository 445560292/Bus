import com.hank.Person

class BootStrap {

    def init = { servletContext ->
        Person person = new Person()
        person.password='admin'
        person.username='admin'
        person.save()
    }
    def destroy = {
    }
}
