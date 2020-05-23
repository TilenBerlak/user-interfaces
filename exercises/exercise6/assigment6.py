import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk

class Handler:
    def aboutCB(self, *args):
        builder.get_object("status").set_text("I am the author!")

    def quitCB(self, *args):
        Gtk.main_quit(*args)

    def openCB(self, *args):
        builder.get_object("fcd").show_all()

    def cancelCB(self, *args):
        builder.get_object("fcd").hide()

    def selectCB(self, *args):
        builder.get_object("fcd").hide()
        builder.get_object("status").set_text(builder.get_object("fcd").get_filename())    

    def convertCB(self, *args):
        conv=1.0991
        value = builder.get_object("spin1").get_value_as_int()
        if (builder.get_object("combo1").get_active()==0):
            value=value*conv
        else:
            value=value/conv
        
        if (builder.get_object("radiobutton1").get_active()):
            value=value*0.98
        builder.get_object("entry1").set_text(str(value))

builder = Gtk.Builder()
builder.add_from_file("assignment6.glade")
builder.connect_signals(Handler())
window = builder.get_object("window")
window.show_all()

Gtk.main()