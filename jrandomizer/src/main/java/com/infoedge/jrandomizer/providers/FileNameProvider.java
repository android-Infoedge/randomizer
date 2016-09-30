package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 30/7/16.
 */

public class FileNameProvider extends FromJsonProvider<FileNameProvider.FileNameData> {

    private FileNameProvider(Class<FileNameData> clazz) {
        super(clazz);
    }

    public static class FileNameData {
        public String[] fileNames;
        public Extensions extensions;
    }

    public static class Extensions {
        public String[] all;
        public String[] common;
        public String[] code;
        public String[] document;
        public String[] image;
        public String[] media;
        public String[] text;
    }

    @Override
    protected String json() {
        return "{\n" +
                "  \"fileNames\": [\n" +
                "    \"A Pede\",\n" +
                "    \"In Tempor\",\n" +
                "    \"Aliquet\",\n" +
                "    \"Non Quam\",\n" +
                "    \"Suscipit A Feugiat\",\n" +
                "    \"Turpis Adipiscing\",\n" +
                "    \"Erat\",\n" +
                "    \"Id Luctus Nec\",\n" +
                "    \"Orci\",\n" +
                "    \"Eget Congue Eget\",\n" +
                "    \"Sem Mauris\",\n" +
                "    \"Turpis\",\n" +
                "    \"Sit\",\n" +
                "    \"Et Tempus Semper\",\n" +
                "    \"Aliquet Maecenas\",\n" +
                "    \"Suspendisse Ornare\",\n" +
                "    \"Libero Quis\",\n" +
                "    \"Felis\",\n" +
                "    \"Pede Ullamcorper\",\n" +
                "    \"Urna\",\n" +
                "    \"Etiam Faucibus Cursus\",\n" +
                "    \"Condimentum Id Luctus\",\n" +
                "    \"Amet\",\n" +
                "    \"Curae Mauris\",\n" +
                "    \"Amet Justo\",\n" +
                "    \"Ipsum\",\n" +
                "    \"Venenatis Tristique\",\n" +
                "    \"Erat Tortor Sollicitudin\",\n" +
                "    \"Sagittis\",\n" +
                "    \"Nam Congue\",\n" +
                "    \"Sociis Natoque Penatibus\",\n" +
                "    \"Posuere Nonummy\",\n" +
                "    \"Phasellus Id Sapien\",\n" +
                "    \"In Quis Justo\",\n" +
                "    \"Sit Amet\",\n" +
                "    \"Elit Sodales\",\n" +
                "    \"Luctus\",\n" +
                "    \"Id\",\n" +
                "    \"Venenatis\",\n" +
                "    \"Semper Rutrum\",\n" +
                "    \"Mi\",\n" +
                "    \"Tempor Convallis Nulla\",\n" +
                "    \"Pellentesque Volutpat\",\n" +
                "    \"Dapibus At\",\n" +
                "    \"Ut Rhoncus Aliquet\",\n" +
                "    \"In Purus Eu\",\n" +
                "    \"Vehicula Consequat Morbi\",\n" +
                "    \"Odio Donec\",\n" +
                "    \"Ut Tellus\",\n" +
                "    \"Non Mauris\",\n" +
                "    \"Diam Vitae\",\n" +
                "    \"Cubilia Curae Nulla\",\n" +
                "    \"Nulla Ut\",\n" +
                "    \"Dui\",\n" +
                "    \"Penatibus\",\n" +
                "    \"Cubilia\",\n" +
                "    \"Consectetuer\",\n" +
                "    \"Et Ultrices Posuere\",\n" +
                "    \"Massa Donec\",\n" +
                "    \"Pellentesque Eget\",\n" +
                "    \"Sapien Non Mi\",\n" +
                "    \"Donec Ut\",\n" +
                "    \"Eget Elit Sodales\",\n" +
                "    \"Est Lacinia\",\n" +
                "    \"Lectus\",\n" +
                "    \"Vestibulum Vestibulum\",\n" +
                "    \"Id Lobortis Convallis\",\n" +
                "    \"Lorem Integer\",\n" +
                "    \"Ultrices Erat Tortor\",\n" +
                "    \"Ac Nibh Fusce\",\n" +
                "    \"Ultrices Posuere\",\n" +
                "    \"Sem\",\n" +
                "    \"Penatibus Et Magnis\",\n" +
                "    \"Lorem\",\n" +
                "    \"Blandit Nam Nulla\",\n" +
                "    \"Risus Praesent Lectus\",\n" +
                "    \"Duis\",\n" +
                "    \"Velit\",\n" +
                "    \"Cras\",\n" +
                "    \"Ligula Sit Amet\",\n" +
                "    \"Nibh Fusce\",\n" +
                "    \"Mi Nulla\",\n" +
                "    \"Potenti\",\n" +
                "    \"Pretium Quis\",\n" +
                "    \"Morbi Porttitor Lorem\",\n" +
                "    \"Vestibulum\",\n" +
                "    \"Ac\",\n" +
                "    \"Luctus Cum\",\n" +
                "    \"Risus Auctor Sed\",\n" +
                "    \"Condimentum\",\n" +
                "    \"Platea Dictumst\",\n" +
                "    \"Faucibus\",\n" +
                "    \"Mi Pede\",\n" +
                "    \"Sed Tristique\",\n" +
                "    \"Consequat Lectus\",\n" +
                "    \"Semper Interdum Mauris\",\n" +
                "    \"Ullamcorper Purus Sit\",\n" +
                "    \"Vel Accumsan\",\n" +
                "    \"Risus\",\n" +
                "    \"Eget\",\n" +
                "    \"A Feugiat\",\n" +
                "    \"Ullamcorper Purus\",\n" +
                "    \"Leo Maecenas\",\n" +
                "    \"Quis Orci\",\n" +
                "    \"Pede Ac\",\n" +
                "    \"Odio Curabitur Convallis\",\n" +
                "    \"Arcu Libero\",\n" +
                "    \"Eu\",\n" +
                "    \"Accumsan Tellus Nisi\",\n" +
                "    \"Tortor\",\n" +
                "    \"In\",\n" +
                "    \"Donec Semper\",\n" +
                "    \"Id Sapien In\",\n" +
                "    \"A\",\n" +
                "    \"Penatibus Et\",\n" +
                "    \"Quam Pharetra\",\n" +
                "    \"Ipsum Primis\",\n" +
                "    \"Nisi\",\n" +
                "    \"Lectus Suspendisse Potenti\",\n" +
                "    \"Justo In Blandit\",\n" +
                "    \"Duis Bibendum Felis\",\n" +
                "    \"In Hac Habitasse\",\n" +
                "    \"Vel\",\n" +
                "    \"Neque Libero\",\n" +
                "    \"Quam A\",\n" +
                "    \"Sapien\",\n" +
                "    \"Ut Massa\",\n" +
                "    \"Sollicitudin Mi\",\n" +
                "    \"Felis Sed Lacus\",\n" +
                "    \"Erat Eros Viverra\",\n" +
                "    \"Libero Rutrum\",\n" +
                "    \"Eu Nibh Quisque\",\n" +
                "    \"Eros Elementum\",\n" +
                "    \"Hendrerit\",\n" +
                "    \"Vehicula\",\n" +
                "    \"Pulvinar Lobortis\",\n" +
                "    \"Erat Quisque Erat\",\n" +
                "    \"Vivamus Tortor\",\n" +
                "    \"Congue Elementum In\",\n" +
                "    \"Mauris\",\n" +
                "    \"Fringilla Rhoncus Mauris\",\n" +
                "    \"Nec Dui Luctus\",\n" +
                "    \"Felis Sed Interdum\",\n" +
                "    \"Morbi\",\n" +
                "    \"Consectetuer Adipiscing\",\n" +
                "    \"Dictumst\",\n" +
                "    \"Magna At\",\n" +
                "    \"Purus Eu\",\n" +
                "    \"Euismod Scelerisque\",\n" +
                "    \"Purus\",\n" +
                "    \"Amet Lobortis\",\n" +
                "    \"Congue\",\n" +
                "    \"Odio\",\n" +
                "    \"Curabitur In\",\n" +
                "    \"Pulvinar\",\n" +
                "    \"Sed Magna\",\n" +
                "    \"Ultrices\",\n" +
                "    \"Ligula In Lacus\",\n" +
                "    \"Enim Lorem\",\n" +
                "    \"Arcu Libero Rutrum\",\n" +
                "    \"Sagittis Nam\",\n" +
                "    \"Curae Nulla\",\n" +
                "    \"Euismod\",\n" +
                "    \"Ante Nulla\",\n" +
                "    \"Aliquet Pulvinar Sed\",\n" +
                "    \"Massa Quis Augue\",\n" +
                "    \"Porttitor Lacus\",\n" +
                "    \"Dui Vel\",\n" +
                "    \"Eros Elementum Pellentesque\",\n" +
                "    \"Dui Luctus Rutrum\",\n" +
                "    \"Enim Sit Amet\",\n" +
                "    \"Sed\",\n" +
                "    \"Nisl Duis Ac\",\n" +
                "    \"Cum Sociis\",\n" +
                "    \"Accumsan Odio Curabitur\",\n" +
                "    \"Nunc Vestibulum Ante\",\n" +
                "    \"Molestie\",\n" +
                "    \"Elit\",\n" +
                "    \"In Eleifend Quam\",\n" +
                "    \"Donec\",\n" +
                "    \"Est\",\n" +
                "    \"Imperdiet Sapien\",\n" +
                "    \"Nisl\",\n" +
                "    \"Nulla Facilisi\",\n" +
                "    \"Viverra\",\n" +
                "    \"Suscipit Nulla\",\n" +
                "    \"A Ipsum Integer\",\n" +
                "    \"Dolor Morbi Vel\",\n" +
                "    \"Nullam Orci Pede\",\n" +
                "    \"Ut Blandit\",\n" +
                "    \"Nisl Venenatis Lacinia\",\n" +
                "    \"Curabitur At\",\n" +
                "    \"Diam Nam\",\n" +
                "    \"Nunc Viverra Dapibus\",\n" +
                "    \"Eu Orci\",\n" +
                "    \"Nunc Donec\",\n" +
                "    \"In Congue\",\n" +
                "    \"Libero Convallis\",\n" +
                "    \"Elementum Nullam\",\n" +
                "    \"Nascetur Ridiculus\",\n" +
                "    \"Gravida\",\n" +
                "    \"Volutpat\",\n" +
                "    \"Metus\",\n" +
                "    \"Nunc\",\n" +
                "    \"Nec Nisi\",\n" +
                "    \"Cursus Urna Ut\",\n" +
                "    \"Quisque Id\",\n" +
                "    \"Mauris Eget\",\n" +
                "    \"Vulputate\",\n" +
                "    \"Congue Elementum\",\n" +
                "    \"Parturient Montes Nascetur\",\n" +
                "    \"Nullam\",\n" +
                "    \"Fermentum Donec\",\n" +
                "    \"Sagittis Dui\",\n" +
                "    \"Dapibus At Diam\",\n" +
                "    \"In Lectus\",\n" +
                "    \"Nonummy\",\n" +
                "    \"Luctus Ultricies\",\n" +
                "    \"Vel Pede\",\n" +
                "    \"Est Congue Elementum\",\n" +
                "    \"Vitae Nisi Nam\",\n" +
                "    \"Vestibulum Rutrum Rutrum\",\n" +
                "    \"Lobortis Ligula Sit\",\n" +
                "    \"Donec Diam\",\n" +
                "    \"Nisi Venenatis\",\n" +
                "    \"Mauris Lacinia Sapien\",\n" +
                "    \"In Felis\",\n" +
                "    \"Adipiscing Molestie Hendrerit\",\n" +
                "    \"Suspendisse Potenti Nullam\",\n" +
                "    \"Maecenas\",\n" +
                "    \"Elementum\",\n" +
                "    \"Imperdiet Sapien Urna\",\n" +
                "    \"Lobortis Convallis\",\n" +
                "    \"Convallis Duis\",\n" +
                "    \"Lectus In Est\",\n" +
                "    \"Pharetra Magna Vestibulum\",\n" +
                "    \"In Felis Donec\",\n" +
                "    \"Justo\",\n" +
                "    \"Sed Nisl\",\n" +
                "    \"Nascetur Ridiculus Mus\",\n" +
                "    \"Purus Phasellus In\",\n" +
                "    \"In Libero Ut\",\n" +
                "    \"Turpis Sed\",\n" +
                "    \"Orci Luctus\",\n" +
                "    \"Integer Ac Leo\",\n" +
                "    \"Ligula\",\n" +
                "    \"Ut At\",\n" +
                "    \"Congue Risus Semper\",\n" +
                "    \"Justo Lacinia\",\n" +
                "    \"Pulvinar Sed\",\n" +
                "    \"Nulla Dapibus\",\n" +
                "    \"At\",\n" +
                "    \"Non\",\n" +
                "    \"Lacus\",\n" +
                "    \"Nec Condimentum\",\n" +
                "    \"Magnis Dis\",\n" +
                "    \"Pellentesque At\",\n" +
                "    \"Et Magnis\",\n" +
                "    \"Diam Neque\",\n" +
                "    \"Aliquet Ultrices\",\n" +
                "    \"Integer Non\",\n" +
                "    \"In Faucibus\",\n" +
                "    \"Nec Molestie\",\n" +
                "    \"Quis\",\n" +
                "    \"Tristique\",\n" +
                "    \"Rutrum At Lorem\",\n" +
                "    \"Elementum Nullam Varius\",\n" +
                "    \"Rhoncus\",\n" +
                "    \"Enim\",\n" +
                "    \"At Feugiat Non\",\n" +
                "    \"Rhoncus Aliquam\",\n" +
                "    \"Hac\",\n" +
                "    \"Ipsum Aliquam Non\",\n" +
                "    \"Natoque\",\n" +
                "    \"Integer\",\n" +
                "    \"Maecenas Pulvinar\",\n" +
                "    \"Tempus\",\n" +
                "    \"Nam Tristique\",\n" +
                "    \"Posuere Metus\",\n" +
                "    \"Et Magnis Dis\",\n" +
                "    \"Sit Amet Erat\",\n" +
                "    \"Massa\",\n" +
                "    \"Orci Luctus Et\",\n" +
                "    \"Vel Enim Sit\",\n" +
                "    \"Leo Pellentesque Ultrices\",\n" +
                "    \"Sagittis Nam Congue\",\n" +
                "    \"Diam In\",\n" +
                "    \"Hac Habitasse\",\n" +
                "    \"Ridiculus Mus\",\n" +
                "    \"Libero Nullam\",\n" +
                "    \"Luctus Nec Molestie\",\n" +
                "    \"Lacinia Eget Tincidunt\",\n" +
                "    \"Et\",\n" +
                "    \"Tincidunt Nulla\",\n" +
                "    \"Tincidunt Ante\",\n" +
                "    \"Accumsan\",\n" +
                "    \"Pharetra Magna\",\n" +
                "    \"Velit Vivamus\",\n" +
                "    \"Ante Vivamus\",\n" +
                "    \"Amet Nunc\",\n" +
                "    \"Eros Suspendisse Accumsan\",\n" +
                "    \"Varius Ut\",\n" +
                "    \"Sit Amet Eleifend\",\n" +
                "    \"Augue Aliquam Erat\",\n" +
                "    \"Quisque Arcu Libero\",\n" +
                "    \"Donec Dapibus Duis\",\n" +
                "    \"In Tempor Turpis\",\n" +
                "    \"Fusce Congue\",\n" +
                "    \"Posuere Cubilia\",\n" +
                "    \"Id Nisl Venenatis\",\n" +
                "    \"Lectus Suspendisse\",\n" +
                "    \"Habitasse Platea\",\n" +
                "    \"Neque Duis\",\n" +
                "    \"Volutpat Sapien\",\n" +
                "    \"Pretium\",\n" +
                "    \"Erat Nulla Tempus\",\n" +
                "    \"Donec Ut Dolor\",\n" +
                "    \"Sed Augue\",\n" +
                "    \"Elementum Ligula\",\n" +
                "    \"Viverra Eget\",\n" +
                "    \"Lacus Curabitur At\",\n" +
                "    \"At Diam\",\n" +
                "    \"Luctus Tincidunt Nulla\",\n" +
                "    \"Magna\",\n" +
                "    \"Fusce\",\n" +
                "    \"Elit Proin\",\n" +
                "    \"Vel Pede Morbi\",\n" +
                "    \"Dis Parturient\",\n" +
                "    \"Eleifend Pede\",\n" +
                "    \"Eu Sapien\",\n" +
                "    \"Porttitor Id Consequat\",\n" +
                "    \"Nulla Ultrices Aliquet\",\n" +
                "    \"Sed Ante Vivamus\",\n" +
                "    \"Nulla Eget Eros\",\n" +
                "    \"Nulla Justo\",\n" +
                "    \"Ante Vel Ipsum\",\n" +
                "    \"Erat Volutpat\",\n" +
                "    \"Ligula Vehicula Consequat\",\n" +
                "    \"Sodales Sed\",\n" +
                "    \"Morbi Sem Mauris\",\n" +
                "    \"Rutrum Ac\",\n" +
                "    \"Nulla Tellus\",\n" +
                "    \"Est Risus\",\n" +
                "    \"Nulla Suspendisse\",\n" +
                "    \"Pretium Nisl\",\n" +
                "    \"Lacinia Erat\",\n" +
                "    \"Est Donec Odio\",\n" +
                "    \"Pede\",\n" +
                "    \"Tortor Sollicitudin\",\n" +
                "    \"Ut\",\n" +
                "    \"Ante Ipsum\",\n" +
                "    \"Parturient Montes\",\n" +
                "    \"Porttitor\",\n" +
                "    \"In Sapien Iaculis\",\n" +
                "    \"Justo Sollicitudin\",\n" +
                "    \"Eget Vulputate\",\n" +
                "    \"Congue Vivamus\",\n" +
                "    \"Imperdiet Et\",\n" +
                "    \"Consequat\",\n" +
                "    \"Mattis\",\n" +
                "    \"Iaculis\",\n" +
                "    \"Justo Lacinia Eget\",\n" +
                "    \"Venenatis Tristique Fusce\",\n" +
                "    \"Praesent\",\n" +
                "    \"Luctus Et\",\n" +
                "    \"Id Nisl\",\n" +
                "    \"Mattis Egestas Metus\",\n" +
                "    \"Convallis Morbi\",\n" +
                "    \"Erat Quisque\",\n" +
                "    \"Tellus Nisi\",\n" +
                "    \"Amet Diam\",\n" +
                "    \"Porttitor Lorem\",\n" +
                "    \"Ante Vel\",\n" +
                "    \"Ante\",\n" +
                "    \"Proin Risus\",\n" +
                "    \"Metus Vitae\",\n" +
                "    \"Et Commodo\",\n" +
                "    \"Eu Est Congue\",\n" +
                "    \"Nam\",\n" +
                "    \"Vulputate Justo\",\n" +
                "    \"Lectus In Quam\",\n" +
                "    \"Sapien Non\",\n" +
                "    \"At Turpis Donec\",\n" +
                "    \"Convallis\",\n" +
                "    \"Ultrices Enim Lorem\",\n" +
                "    \"Nulla\",\n" +
                "    \"Semper Est\",\n" +
                "    \"Cubilia Curae Donec\",\n" +
                "    \"Convallis Duis Consequat\",\n" +
                "    \"Sociis Natoque\",\n" +
                "    \"Ultrices Mattis\",\n" +
                "    \"Nisl Duis\",\n" +
                "    \"Dapibus Dolor\",\n" +
                "    \"Nulla Neque\",\n" +
                "    \"Velit Donec\",\n" +
                "    \"Nibh\",\n" +
                "    \"Convallis Tortor\",\n" +
                "    \"Placerat\",\n" +
                "    \"Lacus At Velit\",\n" +
                "    \"Cum\",\n" +
                "    \"Proin\",\n" +
                "    \"Sagittis Dui Vel\",\n" +
                "    \"Lorem Ipsum\",\n" +
                "    \"Sapien Dignissim\",\n" +
                "    \"Mauris Eget Massa\",\n" +
                "    \"Eget Tincidunt Eget\",\n" +
                "    \"Curabitur At Ipsum\",\n" +
                "    \"Quis Orci Eget\",\n" +
                "    \"Nec Molestie Sed\",\n" +
                "    \"Vehicula Condimentum Curabitur\",\n" +
                "    \"Odio Consequat\",\n" +
                "    \"Sit Amet Cursus\",\n" +
                "    \"Bibendum Morbi\",\n" +
                "    \"Morbi Vestibulum Velit\",\n" +
                "    \"Ultrices Posuere Cubilia\",\n" +
                "    \"Magna Vulputate Luctus\",\n" +
                "    \"Enim Blandit\",\n" +
                "    \"Et Ultrices\",\n" +
                "    \"Vel Sem\",\n" +
                "    \"Aliquam\",\n" +
                "    \"Ullamcorper\",\n" +
                "    \"Elementum In Hac\",\n" +
                "    \"Sapien In\",\n" +
                "    \"Orci Mauris Lacinia\",\n" +
                "    \"Vel Accumsan Tellus\",\n" +
                "    \"Porta Volutpat Erat\",\n" +
                "    \"Sagittis Sapien Cum\",\n" +
                "    \"Risus Dapibus Augue\",\n" +
                "    \"Metus Arcu\",\n" +
                "    \"Cursus Id Turpis\",\n" +
                "    \"Nec\",\n" +
                "    \"Nulla Tempus Vivamus\",\n" +
                "    \"Quam Turpis\",\n" +
                "    \"At Lorem Integer\",\n" +
                "    \"Porta Volutpat Quam\",\n" +
                "    \"Vel Nulla Eget\",\n" +
                "    \"Phasellus Sit\",\n" +
                "    \"Congue Eget Semper\",\n" +
                "    \"Bibendum Morbi Non\",\n" +
                "    \"Dui Vel Sem\",\n" +
                "    \"In Tempus Sit\",\n" +
                "    \"Libero Quis Orci\",\n" +
                "    \"Aliquet At\",\n" +
                "    \"Condimentum Neque\",\n" +
                "    \"Faucibus Orci Luctus\",\n" +
                "    \"Morbi Non Quam\",\n" +
                "    \"Tincidunt\",\n" +
                "    \"Non Velit Donec\",\n" +
                "    \"Mollis Molestie Lorem\",\n" +
                "    \"Nibh In Lectus\",\n" +
                "    \"Quis Tortor Id\",\n" +
                "    \"Quis Augue Luctus\",\n" +
                "    \"Vel Dapibus At\",\n" +
                "    \"Maecenas Ut\",\n" +
                "    \"At Velit Vivamus\",\n" +
                "    \"Primis\",\n" +
                "    \"Lobortis\",\n" +
                "    \"Consequat Ut\",\n" +
                "    \"Augue Quam\",\n" +
                "    \"Volutpat Erat Quisque\",\n" +
                "    \"Praesent Id Massa\",\n" +
                "    \"Nec Nisi Volutpat\",\n" +
                "    \"Posuere Nonummy Integer\",\n" +
                "    \"Montes Nascetur\",\n" +
                "    \"Tortor Id\",\n" +
                "    \"Enim In\",\n" +
                "    \"Ut Nunc Vestibulum\",\n" +
                "    \"Parturient\",\n" +
                "    \"Consequat Morbi\",\n" +
                "    \"Eros\",\n" +
                "    \"Justo Nec Condimentum\",\n" +
                "    \"Dapibus\",\n" +
                "    \"Lacus At\",\n" +
                "    \"Arcu Adipiscing Molestie\",\n" +
                "    \"Fusce Congue Diam\",\n" +
                "    \"Morbi Sem\",\n" +
                "    \"Elementum Eu\",\n" +
                "    \"Vestibulum Proin\",\n" +
                "    \"Vel Nisl\",\n" +
                "    \"Nibh In\",\n" +
                "    \"Id Pretium\",\n" +
                "    \"Lectus Vestibulum\",\n" +
                "    \"Interdum\",\n" +
                "    \"Odio In Hac\",\n" +
                "    \"Platea Dictumst Etiam\",\n" +
                "    \"Id Turpis Integer\",\n" +
                "    \"Eu Est\",\n" +
                "    \"Eleifend Luctus\",\n" +
                "    \"Sit Amet Sem\",\n" +
                "    \"Arcu Sed\",\n" +
                "    \"Sed Ante\",\n" +
                "    \"Sit Amet Consectetuer\",\n" +
                "    \"Lorem Id\",\n" +
                "    \"Imperdiet Nullam\",\n" +
                "    \"Amet Consectetuer Adipiscing\",\n" +
                "    \"Nisi Eu\",\n" +
                "    \"Vitae Nisi\",\n" +
                "    \"Luctus Et Ultrices\",\n" +
                "    \"Habitasse Platea Dictumst\",\n" +
                "    \"Duis Aliquam Convallis\",\n" +
                "    \"In Hac\",\n" +
                "    \"Varius\",\n" +
                "    \"Consequat In\",\n" +
                "    \"Enim Sit\",\n" +
                "    \"Ac Enim In\",\n" +
                "    \"Amet Sem\",\n" +
                "    \"Nisl Nunc Nisl\",\n" +
                "    \"Aliquam Erat Volutpat\",\n" +
                "    \"Nullam Orci\",\n" +
                "    \"Lacinia Nisi\",\n" +
                "    \"Rhoncus Mauris\",\n" +
                "    \"Nisi Vulputate Nonummy\",\n" +
                "    \"Ligula Suspendisse\",\n" +
                "    \"Nisl Ut Volutpat\",\n" +
                "    \"Cursus\",\n" +
                "    \"Eu Tincidunt In\",\n" +
                "    \"Ut Volutpat Sapien\",\n" +
                "    \"Posuere\",\n" +
                "    \"Imperdiet\",\n" +
                "    \"Leo Maecenas Pulvinar\",\n" +
                "    \"Suscipit Nulla Elit\",\n" +
                "    \"Ac Leo\",\n" +
                "    \"Ac Diam\",\n" +
                "    \"Sapien Urna Pretium\",\n" +
                "    \"Pretium Quis Lectus\",\n" +
                "    \"Luctus Rutrum\",\n" +
                "    \"Feugiat Non Pretium\",\n" +
                "    \"Vivamus Vel\",\n" +
                "    \"Sociis\",\n" +
                "    \"Sapien Cum Sociis\",\n" +
                "    \"Lorem Vitae\",\n" +
                "    \"Ante Ipsum Primis\",\n" +
                "    \"Dolor Sit Amet\",\n" +
                "    \"Porttitor Id\",\n" +
                "    \"Quam\",\n" +
                "    \"Vestibulum Ante Ipsum\",\n" +
                "    \"Velit Nec\",\n" +
                "    \"Felis Sed\",\n" +
                "    \"Ut Suscipit\",\n" +
                "    \"Lectus Pellentesque\",\n" +
                "    \"Vel Augue Vestibulum\",\n" +
                "    \"Eget Nunc Donec\",\n" +
                "    \"Cubilia Curae\",\n" +
                "    \"Leo Odio\",\n" +
                "    \"Erat Eros\",\n" +
                "    \"Justo Morbi Ut\",\n" +
                "    \"Pede Morbi Porttitor\",\n" +
                "    \"In Lectus Pellentesque\",\n" +
                "    \"Eget Orci Vehicula\",\n" +
                "    \"Iaculis Justo In\",\n" +
                "    \"Sagittis Sapien\",\n" +
                "    \"Id Nulla Ultrices\",\n" +
                "    \"Nunc Nisl Duis\",\n" +
                "    \"Integer Ac Neque\",\n" +
                "    \"Pede Morbi\",\n" +
                "    \"Lectus In\",\n" +
                "    \"Convallis Eget\",\n" +
                "    \"Ipsum Aliquam\",\n" +
                "    \"Vel Ipsum\",\n" +
                "    \"Eu Magna Vulputate\",\n" +
                "    \"Praesent Blandit Nam\",\n" +
                "    \"At Velit\",\n" +
                "    \"Commodo Placerat Praesent\",\n" +
                "    \"Phasellus\",\n" +
                "    \"Tellus\",\n" +
                "    \"Commodo Vulputate Justo\",\n" +
                "    \"Nullam Sit\",\n" +
                "    \"Magnis\",\n" +
                "    \"Urna Pretium\",\n" +
                "    \"Cursus Vestibulum Proin\",\n" +
                "    \"Nulla Nunc Purus\",\n" +
                "    \"Pretium Iaculis Diam\",\n" +
                "    \"Risus Auctor\",\n" +
                "    \"Mauris Enim Leo\",\n" +
                "    \"Sapien Iaculis Congue\",\n" +
                "    \"Semper\",\n" +
                "    \"Pretium Iaculis Justo\",\n" +
                "    \"Porttitor Lorem Id\",\n" +
                "    \"Duis Mattis\",\n" +
                "    \"Vestibulum Aliquet Ultrices\",\n" +
                "    \"Nunc Purus\",\n" +
                "    \"Velit Nec Nisi\",\n" +
                "    \"Quam Sapien Varius\",\n" +
                "    \"Non Interdum In\",\n" +
                "    \"Curabitur\",\n" +
                "    \"Sapien Ut\",\n" +
                "    \"Mattis Egestas\",\n" +
                "    \"Dapibus Augue\",\n" +
                "    \"In Quam\",\n" +
                "    \"Tellus In Sagittis\",\n" +
                "    \"Pellentesque Ultrices\",\n" +
                "    \"Praesent Blandit\",\n" +
                "    \"Scelerisque Quam\",\n" +
                "    \"Dolor\",\n" +
                "    \"Lacus Curabitur\",\n" +
                "    \"Mauris Sit Amet\",\n" +
                "    \"Amet Eros\",\n" +
                "    \"Interdum In\",\n" +
                "    \"Odio Condimentum\",\n" +
                "    \"Quisque Erat\",\n" +
                "    \"Diam Vitae Quam\",\n" +
                "    \"Duis Mattis Egestas\",\n" +
                "    \"Quam Suspendisse\",\n" +
                "    \"Volutpat Convallis\",\n" +
                "    \"Quis Orci Nullam\",\n" +
                "    \"Sit Amet Lobortis\",\n" +
                "    \"Suscipit\",\n" +
                "    \"Turpis Enim Blandit\",\n" +
                "    \"Sollicitudin Vitae Consectetuer\",\n" +
                "    \"Adipiscing Elit\",\n" +
                "    \"Sollicitudin Mi Sit\",\n" +
                "    \"Vestibulum Eget Vulputate\",\n" +
                "    \"Quam Pede\",\n" +
                "    \"Morbi A Ipsum\",\n" +
                "    \"Tempus Semper\",\n" +
                "    \"Eleifend Pede Libero\",\n" +
                "    \"Vulputate Ut\",\n" +
                "    \"Amet Eleifend Pede\",\n" +
                "    \"Aenean Sit Amet\",\n" +
                "    \"Pede Malesuada\",\n" +
                "    \"Augue Aliquam\",\n" +
                "    \"Aenean Lectus\",\n" +
                "    \"Nulla Suspendisse Potenti\",\n" +
                "    \"Malesuada\",\n" +
                "    \"Posuere Metus Vitae\",\n" +
                "    \"Sollicitudin Vitae\",\n" +
                "    \"Est Quam Pharetra\",\n" +
                "    \"Integer Tincidunt Ante\",\n" +
                "    \"Luctus Rutrum Nulla\",\n" +
                "    \"Et Eros Vestibulum\",\n" +
                "    \"Blandit Ultrices Enim\",\n" +
                "    \"Nisl Aenean\",\n" +
                "    \"Vulputate Luctus\",\n" +
                "    \"Justo Aliquam Quis\",\n" +
                "    \"Curae Mauris Viverra\",\n" +
                "    \"Nulla Ac Enim\",\n" +
                "    \"Justo In Hac\",\n" +
                "    \"Suspendisse Potenti\",\n" +
                "    \"Integer Non Velit\",\n" +
                "    \"Ac Tellus\",\n" +
                "    \"Blandit Non Interdum\",\n" +
                "    \"Rutrum Nulla Tellus\",\n" +
                "    \"Augue\",\n" +
                "    \"Quisque Porta Volutpat\",\n" +
                "    \"Ac Consequat\",\n" +
                "    \"Amet Sem Fusce\",\n" +
                "    \"Scelerisque\",\n" +
                "    \"Eget Eros\",\n" +
                "    \"Vel Est\",\n" +
                "    \"Sapien Sapien Non\",\n" +
                "    \"Sed Magna At\",\n" +
                "    \"Tortor Quis\",\n" +
                "    \"Lacus Purus Aliquet\",\n" +
                "    \"In Leo Maecenas\",\n" +
                "    \"Morbi Ut\",\n" +
                "    \"Rhoncus Dui Vel\"\n" +
                "  ],\n" +
                "  \"extensions\": {\n" +
                "    \"all\": [\n" +
                "      \".f77\",\n" +
                "      \".mid\",\n" +
                "      \".sgml\",\n" +
                "      \".mp2\",\n" +
                "      \".wmlsc\",\n" +
                "      \".g\",\n" +
                "      \".vrml\",\n" +
                "      \".vmd\",\n" +
                "      \".texinfo\",\n" +
                "      \".xyz\",\n" +
                "      \".xla\",\n" +
                "      \".avi\",\n" +
                "      \".book\",\n" +
                "      \".pfunk\",\n" +
                "      \".rm\",\n" +
                "      \".skp\",\n" +
                "      \".w6w\",\n" +
                "      \".zip\",\n" +
                "      \".dcr\",\n" +
                "      \".aip\",\n" +
                "      \".qt\",\n" +
                "      \".mpg\",\n" +
                "      \".java\",\n" +
                "      \".shtml\",\n" +
                "      \".xlt\",\n" +
                "      \".vcd\",\n" +
                "      \".mcd\",\n" +
                "      \".cdf\",\n" +
                "      \".pot\",\n" +
                "      \".crt\",\n" +
                "      \".cpp\",\n" +
                "      \".tbk\",\n" +
                "      \".rmm\",\n" +
                "      \".midi\",\n" +
                "      \".ppt\",\n" +
                "      \".asf\",\n" +
                "      \".wrl\",\n" +
                "      \".rng\",\n" +
                "      \".m\",\n" +
                "      \".unis\",\n" +
                "      \".cer\",\n" +
                "      \".mpp\",\n" +
                "      \".c++\",\n" +
                "      \".ani\",\n" +
                "      \".js\",\n" +
                "      \".asp\",\n" +
                "      \".rtf\",\n" +
                "      \".p7m\",\n" +
                "      \".wk1\",\n" +
                "      \".gl\",\n" +
                "      \".tex\",\n" +
                "      \".jpe\",\n" +
                "      \".smi\",\n" +
                "      \".gzip\",\n" +
                "      \".hlp\",\n" +
                "      \".flo\",\n" +
                "      \".com\",\n" +
                "      \".g3\",\n" +
                "      \".c\",\n" +
                "      \".dl\",\n" +
                "      \".uri\",\n" +
                "      \".dwf\",\n" +
                "      \".aas\",\n" +
                "      \".nvd\",\n" +
                "      \".ssi\",\n" +
                "      \".gsp\",\n" +
                "      \".cc\",\n" +
                "      \".ksh\",\n" +
                "      \".lhx\",\n" +
                "      \".aifc\",\n" +
                "      \".omcd\",\n" +
                "      \".mzz\",\n" +
                "      \".gz\",\n" +
                "      \".spc\",\n" +
                "      \".xm\",\n" +
                "      \".ivr\",\n" +
                "      \".viv\",\n" +
                "      \".imap\",\n" +
                "      \".wiz\",\n" +
                "      \".xlm\",\n" +
                "      \".hpgl\",\n" +
                "      \".vql\",\n" +
                "      \".smil\",\n" +
                "      \".pov\",\n" +
                "      \".vcs\",\n" +
                "      \".tsp\",\n" +
                "      \".wpd\",\n" +
                "      \".igs\",\n" +
                "      \".env\",\n" +
                "      \".hqx\",\n" +
                "      \".mv\",\n" +
                "      \".ram\",\n" +
                "      \".bz\",\n" +
                "      \".ppa\",\n" +
                "      \".bm\",\n" +
                "      \".wp5\",\n" +
                "      \".el\",\n" +
                "      \".m2a\",\n" +
                "      \".fpx\",\n" +
                "      \".lma\",\n" +
                "      \".wav\",\n" +
                "      \".ima\",\n" +
                "      \".zoo\",\n" +
                "      \".bz2\",\n" +
                "      \".rmp\",\n" +
                "      \".nif\",\n" +
                "      \".dif\",\n" +
                "      \".svr\",\n" +
                "      \".bin\",\n" +
                "      \".uue\",\n" +
                "      \".xpm\",\n" +
                "      \".elc\",\n" +
                "      \".pict\",\n" +
                "      \".flx\",\n" +
                "      \".svf\",\n" +
                "      \".tgz\",\n" +
                "      \".xlv\",\n" +
                "      \".ps\",\n" +
                "      \".xls\",\n" +
                "      \".class\",\n" +
                "      \".o\",\n" +
                "      \".jut\",\n" +
                "      \".sh\",\n" +
                "      \".hlb\",\n" +
                "      \".sol\",\n" +
                "      \".lzx\",\n" +
                "      \".for\",\n" +
                "      \".wb1\",\n" +
                "      \".jpg\",\n" +
                "      \".scm\",\n" +
                "      \".es\",\n" +
                "      \".dwg\",\n" +
                "      \".rpm\",\n" +
                "      \".prt\",\n" +
                "      \".ustar\",\n" +
                "      \".jcm\",\n" +
                "      \".m1v\",\n" +
                "      \".p7r\",\n" +
                "      \".au\",\n" +
                "      \".cpt\",\n" +
                "      \".xld\",\n" +
                "      \".asx\",\n" +
                "      \".pgm\",\n" +
                "      \".p7c\",\n" +
                "      \".f90\",\n" +
                "      \".mp3\",\n" +
                "      \".h\",\n" +
                "      \".gss\",\n" +
                "      \".sea\",\n" +
                "      \".vst\",\n" +
                "      \".uris\",\n" +
                "      \".wmf\",\n" +
                "      \".xlw\",\n" +
                "      \".snd\",\n" +
                "      \".xlb\",\n" +
                "      \".bmp\",\n" +
                "      \".saveme\",\n" +
                "      \".uu\",\n" +
                "      \".ai\",\n" +
                "      \".web\",\n" +
                "      \".evy\",\n" +
                "      \".roff\",\n" +
                "      \".moov\",\n" +
                "      \".crl\",\n" +
                "      \".talk\",\n" +
                "      \".bsh\",\n" +
                "      \".dvi\",\n" +
                "      \".mpx\",\n" +
                "      \".wri\",\n" +
                "      \".p\",\n" +
                "      \".xml\",\n" +
                "      \".abc\",\n" +
                "      \".wtk\",\n" +
                "      \".xlc\",\n" +
                "      \".lha\",\n" +
                "      \".dxr\",\n" +
                "      \".shar\",\n" +
                "      \".rnx\",\n" +
                "      \".mov\",\n" +
                "      \".vda\",\n" +
                "      \".vivo\",\n" +
                "      \".pnm\",\n" +
                "      \".map\",\n" +
                "      \".sst\",\n" +
                "      \".lsx\",\n" +
                "      \".xll\",\n" +
                "      \".lst\",\n" +
                "      \".spr\",\n" +
                "      \".niff\",\n" +
                "      \".me\",\n" +
                "      \".arj\",\n" +
                "      \".skm\",\n" +
                "      \".frl\",\n" +
                "      \".hta\",\n" +
                "      \".mc$\",\n" +
                "      \".aiff\",\n" +
                "      \".htmls\",\n" +
                "      \".jps\",\n" +
                "      \".nc\",\n" +
                "      \".iefs\",\n" +
                "      \".psd\",\n" +
                "      \".f\",\n" +
                "      \".aps\",\n" +
                "      \".ins\",\n" +
                "      \".pps\",\n" +
                "      \".pm\",\n" +
                "      \".mm\",\n" +
                "      \".pl\",\n" +
                "      \".mpe\",\n" +
                "      \".tsi\",\n" +
                "      \".mcf\",\n" +
                "      \".xwd\",\n" +
                "      \".rtx\",\n" +
                "      \".unv\",\n" +
                "      \".log\",\n" +
                "      \".dv\",\n" +
                "      \".latex\",\n" +
                "      \".p7a\",\n" +
                "      \".tiff\",\n" +
                "      \".a\",\n" +
                "      \".t\",\n" +
                "      \".fdf\",\n" +
                "      \".pbm\",\n" +
                "      \".ra\",\n" +
                "      \".sgm\",\n" +
                "      \".dp\",\n" +
                "      \".vmf\",\n" +
                "      \".kar\",\n" +
                "      \".jpeg\",\n" +
                "      \".s\",\n" +
                "      \".sdr\",\n" +
                "      \".tif\",\n" +
                "      \".exe\",\n" +
                "      \".mime\",\n" +
                "      \".boo\",\n" +
                "      \".mar\",\n" +
                "      \".rt\",\n" +
                "      \".uni\",\n" +
                "      \".mrc\",\n" +
                "      \".xlk\",\n" +
                "      \".texi\",\n" +
                "      \".ief\",\n" +
                "      \".hh\",\n" +
                "      \".mpga\",\n" +
                "      \".mme\",\n" +
                "      \".voc\",\n" +
                "      \".qd3d\",\n" +
                "      \".afl\",\n" +
                "      \".tar\",\n" +
                "      \".chat\",\n" +
                "      \".pko\",\n" +
                "      \".xdr\",\n" +
                "      \".xpix\",\n" +
                "      \".csh\",\n" +
                "      \".help\",\n" +
                "      \".tcsh\",\n" +
                "      \".vqe\",\n" +
                "      \".vox\",\n" +
                "      \".stp\",\n" +
                "      \".la\",\n" +
                "      \".vos\",\n" +
                "      \".gsm\",\n" +
                "      \".vqf\",\n" +
                "      \".ppm\",\n" +
                "      \".deepv\",\n" +
                "      \".xgz\",\n" +
                "      \".ico\",\n" +
                "      \".mpc\",\n" +
                "      \".idc\",\n" +
                "      \".iges\",\n" +
                "      \".htm\",\n" +
                "      \".jav\",\n" +
                "      \".mod\",\n" +
                "      \".lzh\",\n" +
                "      \".cpio\",\n" +
                "      \".rexx\",\n" +
                "      \".aam\",\n" +
                "      \".gtar\",\n" +
                "      \".mbd\",\n" +
                "      \".stl\",\n" +
                "      \".dxf\",\n" +
                "      \".pct\",\n" +
                "      \".sit\",\n" +
                "      \".funk\",\n" +
                "      \".xbm\",\n" +
                "      \".turbot\",\n" +
                "      \".z\",\n" +
                "      \".set\",\n" +
                "      \".arc\",\n" +
                "      \".pm4\",\n" +
                "      \".pcl\",\n" +
                "      \".tcl\",\n" +
                "      \".mhtml\",\n" +
                "      \".ras\",\n" +
                "      \".3dm\",\n" +
                "      \".text\",\n" +
                "      \".spl\",\n" +
                "      \".htc\",\n" +
                "      \".pyc\",\n" +
                "      \".3dmf\",\n" +
                "      \".ncm\",\n" +
                "      \".css\",\n" +
                "      \".mjf\",\n" +
                "      \".aif\",\n" +
                "      \".pvu\",\n" +
                "      \".wrz\",\n" +
                "      \".lsp\",\n" +
                "      \".pdf\",\n" +
                "      \".dump\",\n" +
                "      \".sv4cpio\",\n" +
                "      \".pcx\",\n" +
                "      \".nix\",\n" +
                "      \".p10\",\n" +
                "      \".wmlc\",\n" +
                "      \".vrt\",\n" +
                "      \".qti\",\n" +
                "      \".doc\",\n" +
                "      \".ssm\",\n" +
                "      \".htx\",\n" +
                "      \".conf\",\n" +
                "      \".avs\",\n" +
                "      \".jfif\",\n" +
                "      \".pwz\",\n" +
                "      \".tsv\",\n" +
                "      \".hpg\",\n" +
                "      \".xmz\",\n" +
                "      \".nap\",\n" +
                "      \".mpa\",\n" +
                "      \".p12\",\n" +
                "      \".ltx\",\n" +
                "      \".ice\",\n" +
                "      \".m2v\",\n" +
                "      \".plx\",\n" +
                "      \".hgl\",\n" +
                "      \".rv\",\n" +
                "      \".qtif\",\n" +
                "      \".sdp\",\n" +
                "      \".wq1\",\n" +
                "      \".sdml\",\n" +
                "      \".p7s\",\n" +
                "      \".xl\",\n" +
                "      \".part\",\n" +
                "      \".wsrc\",\n" +
                "      \".vew\",\n" +
                "      \".src\",\n" +
                "      \".inf\",\n" +
                "      \".htt\",\n" +
                "      \".iv\",\n" +
                "      \".pas\",\n" +
                "      \".vsd\",\n" +
                "      \".sprite\",\n" +
                "      \".step\",\n" +
                "      \".mcp\",\n" +
                "      \".mjpg\",\n" +
                "      \".ppz\",\n" +
                "      \".qtc\",\n" +
                "      \".def\",\n" +
                "      \".fif\",\n" +
                "      \".rp\",\n" +
                "      \".it\",\n" +
                "      \".hdf\",\n" +
                "      \".asm\",\n" +
                "      \".png\",\n" +
                "      \".mpt\",\n" +
                "      \".bcpio\",\n" +
                "      \".der\",\n" +
                "      \".html\"\n" +
                "    ],\n" +
                "    \"common\": [\n" +
                "      \".mp3\",\n" +
                "      \".xls\",\n" +
                "      \".doc\",\n" +
                "      \".ppt\",\n" +
                "      \".avi\",\n" +
                "      \".mpeg\",\n" +
                "      \".txt\",\n" +
                "      \".mov\",\n" +
                "      \".jpeg\",\n" +
                "      \".pdf\",\n" +
                "      \".png\",\n" +
                "      \".tiff\",\n" +
                "      \".gif\"\n" +
                "    ],\n" +
                "    \"code\": [\n" +
                "      \".js\",\n" +
                "      \".java\",\n" +
                "      \".css\",\n" +
                "      \".html\"\n" +
                "    ],\n" +
                "    \"document\" : [\n" +
                "        \".xls\",\n" +
                "        \".ppt\",\n" +
                "        \".doc\",\n" +
                "        \".pdf\"\n" +
                "    ],\n" +
                "    \"image\" : [\n" +
                "        \".tiff\",\n" +
                "        \".png\",\n" +
                "        \".jpeg\",\n" +
                "        \".gif\"\n" +
                "    ],\n" +
                "    \"media\" : [\n" +
                "        \".mov\",\n" +
                "        \".mp3\",\n" +
                "        \".avi\",\n" +
                "        \".mpeg\"\n" +
                "    ],\n" +
                "    \"text\" : [\n" +
                "        \".txt\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }
}
