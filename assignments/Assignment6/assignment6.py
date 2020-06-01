import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk

class Handler:

    def odpriCB(self, *args):
        builder.get_object("fcd").show_all()

    def izhodCB(self, *args):
        Gtk.main_quit(*args)

    def cancelCB(self, *args):
        builder.get_object("fcd").hide()

    def izbere1tCB(self, *args):
        text = builder.get_object("status").get_text()
        builder.get_object("status").set_text(text + "T")

builder = Gtk.Builder()
builder.add_from_file("assignment6.glade")
builder.connect_signals(Handler())
window = builder.get_object("window")
window.show_all()

Gtk.main()