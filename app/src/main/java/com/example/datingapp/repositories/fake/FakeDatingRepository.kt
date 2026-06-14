package com.example.datingapp.repositories.fake

import com.example.datingapp.models.DatingProfile
import com.example.datingapp.models.Match
import com.example.datingapp.repositories.DatingRepository

class FakeDatingRepository : DatingRepository {
    private val likedProfileIds = mutableSetOf<String>()
    private val skippedProfileIds = mutableSetOf<String>()
    private val matches = mutableListOf<Match>()

    private val profiles = mutableListOf<DatingProfile>(
        DatingProfile(id = "profile_1", name = "Анна", age = 24, city = "Москва", about = "Люблю путешествия, кофе и прогулки по городу.", photoUrl = null),
        DatingProfile(id = "profile_2", name = "Мария", age = 27, city = "Санкт-Петербург", about = "Занимаюсь йогой, читаю книги и люблю собак.", photoUrl = null),
        DatingProfile(id = "profile_3", name = "Екатерина", age = 22, city = "Казань", about = "Люблю кино, вечерние прогулки и хорошую музыку.", photoUrl = null),
        DatingProfile(id = "profile_4", name = "Ольга", age = 29, city = "Новосибирск", about = "Ищу интересное общение и человека с чувством юмора.", photoUrl = null),
        DatingProfile(id = "profile_5", name = "София", age = 25, city = "Екатеринбург", about = "Фотография, спорт и спонтанные поездки — это про меня.", photoUrl = null),
        DatingProfile(id = "profile_6", name = "Алина", age = 23, city = "Москва", about = "Обожаю готовить и устраивать уютные вечера дома.", photoUrl = null),
        DatingProfile(id = "profile_7", name = "Виктория", age = 26, city = "Краснодар", about = "Танцую сальсу и мечтаю объездить всю Европу.", photoUrl = null),
        DatingProfile(id = "profile_8", name = "Наталья", age = 30, city = "Самара", about = "Люблю природу, походы и тихие вечера у костра.", photoUrl = null),
        DatingProfile(id = "profile_9", name = "Дарья", age = 21, city = "Ростов-на-Дону", about = "Студентка, увлекаюсь рисованием и аниме.", photoUrl = null),
        DatingProfile(id = "profile_10", name = "Полина", age = 28, city = "Уфа", about = "Работаю дизайнером, ценю эстетику во всём.", photoUrl = null),
        DatingProfile(id = "profile_11", name = "Ксения", age = 24, city = "Пермь", about = "Обожаю театр, классическую музыку и хорошее вино.", photoUrl = null),
        DatingProfile(id = "profile_12", name = "Юлия", age = 27, city = "Волгоград", about = "Спортсменка, люблю бег и здоровый образ жизни.", photoUrl = null),
        DatingProfile(id = "profile_13", name = "Татьяна", age = 31, city = "Омск", about = "Мама двух кошек, люблю уют и домашнюю атмосферу.", photoUrl = null),
        DatingProfile(id = "profile_14", name = "Ирина", age = 26, city = "Челябинск", about = "IT-специалист, увлекаюсь настольными играми.", photoUrl = null),
        DatingProfile(id = "profile_15", name = "Валерия", age = 22, city = "Красноярск", about = "Люблю горы, сноуборд и горячий чай после катания.", photoUrl = null),
        DatingProfile(id = "profile_16", name = "Анастасия", age = 25, city = "Воронеж", about = "Пишу стихи и обожаю литературные вечера.", photoUrl = null),
        DatingProfile(id = "profile_17", name = "Елена", age = 29, city = "Саратов", about = "Врач по профессии, добрая и внимательная по натуре.", photoUrl = null),
        DatingProfile(id = "profile_18", name = "Кристина", age = 23, city = "Тюмень", about = "Увлекаюсь астрологией и медитацией.", photoUrl = null),
        DatingProfile(id = "profile_19", name = "Людмила", age = 32, city = "Иркутск", about = "Люблю готовить экзотические блюда и принимать гостей.", photoUrl = null),
        DatingProfile(id = "profile_20", name = "Светлана", age = 27, city = "Хабаровск", about = "Фанат активного отдыха и водных видов спорта.", photoUrl = null),
        DatingProfile(id = "profile_21", name = "Надежда", age = 24, city = "Владивосток", about = "Люблю море, закаты и долгие разговоры о жизни.", photoUrl = null),
        DatingProfile(id = "profile_22", name = "Вера", age = 28, city = "Томск", about = "Преподаю английский, мечтаю пожить за границей.", photoUrl = null),
        DatingProfile(id = "profile_23", name = "Галина", age = 33, city = "Кемерово", about = "Садовод-любитель и поклонница скандинавского стиля.", photoUrl = null),
        DatingProfile(id = "profile_24", name = "Оксана", age = 26, city = "Нижний Новгород", about = "Журналист, пишу о моде и культуре.", photoUrl = null),
        DatingProfile(id = "profile_25", name = "Тамара", age = 30, city = "Ярославль", about = "Люблю антикварные магазины и старые фильмы.", photoUrl = null),
        DatingProfile(id = "profile_26", name = "Зоя", age = 22, city = "Астрахань", about = "Рыбачу с папой с детства, обожаю природу.", photoUrl = null),
        DatingProfile(id = "profile_27", name = "Маргарита", age = 25, city = "Барнаул", about = "Занимаюсь акробатикой и современными танцами.", photoUrl = null),
        DatingProfile(id = "profile_28", name = "Лариса", age = 31, city = "Владимир", about = "Историк по образованию, люблю музеи и экскурсии.", photoUrl = null),
        DatingProfile(id = "profile_29", name = "Нина", age = 27, city = "Тверь", about = "Кондитер, пеку торты и делаю людей счастливее.", photoUrl = null),
        DatingProfile(id = "profile_30", name = "Регина", age = 23, city = "Липецк", about = "Увлекаюсь скейтбордингом и уличным искусством.", photoUrl = null),
        DatingProfile(id = "profile_31", name = "Жанна", age = 28, city = "Пенза", about = "Люблю джаз, арт-галереи и неспешные прогулки.", photoUrl = null),
        DatingProfile(id = "profile_32", name = "Милена", age = 21, city = "Брянск", about = "Студентка мединститута, обожаю волонтёрство.", photoUrl = null),
        DatingProfile(id = "profile_33", name = "Карина", age = 26, city = "Калуга", about = "Веду фудблог и постоянно ищу новые рецепты.", photoUrl = null),
        DatingProfile(id = "profile_34", name = "Стелла", age = 24, city = "Орёл", about = "Мечтаю стать актрисой, пока играю в студенческом театре.", photoUrl = null),
        DatingProfile(id = "profile_35", name = "Диана", age = 29, city = "Курск", about = "Юрист, серьёзная на работе и весёлая в жизни.", photoUrl = null),
        DatingProfile(id = "profile_36", name = "Инна", age = 27, city = "Иваново", about = "Дизайнер одежды, люблю необычные образы.", photoUrl = null),
        DatingProfile(id = "profile_37", name = "Вероника", age = 23, city = "Белгород", about = "Обожаю скалолазание и всё что связано с высотой.", photoUrl = null),
        DatingProfile(id = "profile_38", name = "Эвелина", age = 25, city = "Тула", about = "Люблю комедии, пиццу и компанию хороших друзей.", photoUrl = null),
        DatingProfile(id = "profile_39", name = "Лилия", age = 30, city = "Рязань", about = "Флорист, создаю красоту из живых цветов.", photoUrl = null),
        DatingProfile(id = "profile_40", name = "Алёна", age = 22, city = "Смоленск", about = "Геймер и косплеер, участвую в фестивалях.", photoUrl = null),
        DatingProfile(id = "profile_41", name = "Августина", age = 27, city = "Архангельск", about = "Люблю зиму, северное сияние и горячий шоколад.", photoUrl = null),
        DatingProfile(id = "profile_42", name = "Злата", age = 24, city = "Мурманск", about = "Дайвер, влюблена в подводный мир.", photoUrl = null),
        DatingProfile(id = "profile_43", name = "Ульяна", age = 26, city = "Сочи", about = "Живу у моря и не представляю жизни без него.", photoUrl = null),
        DatingProfile(id = "profile_44", name = "Лада", age = 28, city = "Ставрополь", about = "Занимаюсь конным спортом и люблю животных.", photoUrl = null),
        DatingProfile(id = "profile_45", name = "Рита", age = 21, city = "Махачкала", about = "Танцую лезгинку и горжусь своей культурой.", photoUrl = null),
        DatingProfile(id = "profile_46", name = "Яна", age = 25, city = "Грозный", about = "Люблю горы и умею готовить вкуснейший плов.", photoUrl = null),
        DatingProfile(id = "profile_47", name = "Элина", age = 29, city = "Нальчик", about = "Психолог, умею слушать и понимать людей.", photoUrl = null),
        DatingProfile(id = "profile_48", name = "Лиза", age = 23, city = "Майкоп", about = "Обожаю кемпинг и звёздное небо вдали от города.", photoUrl = null),
        DatingProfile(id = "profile_49", name = "Илона", age = 27, city = "Якутск", about = "Живу в самом холодном городе и люблю это.", photoUrl = null),
        DatingProfile(id = "profile_50", name = "Аделина", age = 24, city = "Улан-Удэ", about = "Занимаюсь буддийскими практиками и медитацией.", photoUrl = null),
        DatingProfile(id = "profile_51", name = "Нэлли", age = 26, city = "Чита", about = "Люблю длинные поезда и бесконечные просторы.", photoUrl = null),
        DatingProfile(id = "profile_52", name = "Таисия", age = 22, city = "Благовещенск", about = "Изучаю китайский язык и китайскую культуру.", photoUrl = null),
        DatingProfile(id = "profile_53", name = "Варвара", age = 30, city = "Биробиджан", about = "Художник, рисую акварелью и маслом.", photoUrl = null),
        DatingProfile(id = "profile_54", name = "Прасковья", age = 28, city = "Южно-Сахалинск", about = "Люблю рыбалку и морепродукты.", photoUrl = null),
        DatingProfile(id = "profile_55", name = "Агата", age = 25, city = "Петропавловск-Камчатский", about = "Живу рядом с вулканами и это восхитительно.", photoUrl = null),
        DatingProfile(id = "profile_56", name = "Богдана", age = 23, city = "Магадан", about = "Геолог, исследую дальние края страны.", photoUrl = null),
        DatingProfile(id = "profile_57", name = "Дина", age = 27, city = "Сыктывкар", about = "Люблю лыжи, тайгу и домашних оленей.", photoUrl = null),
        DatingProfile(id = "profile_58", name = "Леся", age = 24, city = "Нарьян-Мар", about = "Романтик севера, обожаю белые ночи.", photoUrl = null),
        DatingProfile(id = "profile_59", name = "Эльза", age = 29, city = "Салехард", about = "Этнограф, изучаю культуру народов Севера.", photoUrl = null),
        DatingProfile(id = "profile_60", name = "Айгуль", age = 25, city = "Ханты-Мансийск", about = "Люблю степные просторы и народные песни.", photoUrl = null),
        DatingProfile(id = "profile_61", name = "Гульнара", age = 28, city = "Тобольск", about = "Историк и краевед, знаю всё о своём городе.", photoUrl = null),
        DatingProfile(id = "profile_62", name = "Фатима", age = 26, city = "Дербент", about = "Один из древнейших городов — мой дом.", photoUrl = null),
        DatingProfile(id = "profile_63", name = "Земфира", age = 23, city = "Владикавказ", about = "Музыкант, играю на скрипке в оркестре.", photoUrl = null),
        DatingProfile(id = "profile_64", name = "Лейла", age = 27, city = "Элиста", about = "Люблю шахматы — шахматная столица России моя.", photoUrl = null),
        DatingProfile(id = "profile_65", name = "Мадина", age = 24, city = "Черкесск", about = "Занимаюсь джиу-джитсу и горжусь этим.", photoUrl = null),
        DatingProfile(id = "profile_66", name = "Залина", age = 22, city = "Магас", about = "Самый молодой город России — самая молодая душа.", photoUrl = null),
        DatingProfile(id = "profile_67", name = "Хадижат", age = 29, city = "Махачкала", about = "Архитектор, проектирую красивые пространства.", photoUrl = null),
        DatingProfile(id = "profile_68", name = "Амина", age = 25, city = "Назрань", about = "Люблю семью, уют и вкусную еду.", photoUrl = null),
        DatingProfile(id = "profile_69", name = "Сабина", age = 27, city = "Грозный", about = "Стилист, помогаю людям найти свой образ.", photoUrl = null),
        DatingProfile(id = "profile_70", name = "Тина", age = 26, city = "Сочи", about = "Инструктор по серфингу, море — моя стихия.", photoUrl = null),
        DatingProfile(id = "profile_71", name = "Белла", age = 24, city = "Краснодар", about = "Фермер и любитель органических продуктов.", photoUrl = null),
        DatingProfile(id = "profile_72", name = "Ника", age = 21, city = "Ростов-на-Дону", about = "Начинающий блогер, снимаю видео о путешествиях.", photoUrl = null),
        DatingProfile(id = "profile_73", name = "Мила", age = 28, city = "Самара", about = "Актриса местного театра, живу сценой.", photoUrl = null),
        DatingProfile(id = "profile_74", name = "Ася", age = 23, city = "Саратов", about = "Обожаю велопрогулки и пикники в парке.", photoUrl = null),
        DatingProfile(id = "profile_75", name = "Ева", age = 26, city = "Казань", about = "Изучаю татарскую культуру и язык.", photoUrl = null),
        DatingProfile(id = "profile_76", name = "Нора", age = 30, city = "Уфа", about = "Башкирские просторы — лучшее место на Земле.", photoUrl = null),
        DatingProfile(id = "profile_77", name = "Роза", age = 25, city = "Пермь", about = "Биолог, занимаюсь изучением флоры Урала.", photoUrl = null),
        DatingProfile(id = "profile_78", name = "Майя", age = 27, city = "Екатеринбург", about = "Программист, люблю решать сложные задачи.", photoUrl = null),
        DatingProfile(id = "profile_79", name = "Ирма", age = 24, city = "Челябинск", about = "Мастер маникюра и большой фанат корейской косметики.", photoUrl = null),
        DatingProfile(id = "profile_80", name = "Лора", age = 29, city = "Тюмень", about = "Нефтяник по профессии, романтик по натуре.", photoUrl = null),
        DatingProfile(id = "profile_81", name = "Стася", age = 22, city = "Омск", about = "Люблю квесты, головоломки и детективные истории.", photoUrl = null),
        DatingProfile(id = "profile_82", name = "Пола", age = 26, city = "Красноярск", about = "Сибирячка, обожаю Енисей и тайгу.", photoUrl = null),
        DatingProfile(id = "profile_83", name = "Тоня", age = 28, city = "Иркутск", about = "Байкал рядом — разве можно быть несчастной?", photoUrl = null),
        DatingProfile(id = "profile_84", name = "Ива", age = 25, city = "Улан-Удэ", about = "Изучаю буддизм и восточную философию.", photoUrl = null),
        DatingProfile(id = "profile_85", name = "Клара", age = 31, city = "Томск", about = "Профессор университета, люблю науку и студентов.", photoUrl = null),
        DatingProfile(id = "profile_86", name = "Люда", age = 24, city = "Новосибирск", about = "Академгородок — место где живёт моя душа.", photoUrl = null),
        DatingProfile(id = "profile_87", name = "Мирра", age = 27, city = "Кемерово", about = "Шахтёрский город с золотым сердцем.", photoUrl = null),
        DatingProfile(id = "profile_88", name = "Лана", age = 23, city = "Барнаул", about = "Живу на Алтае и наслаждаюсь каждым днём.", photoUrl = null),
        DatingProfile(id = "profile_89", name = "Дана", age = 26, city = "Горно-Алтайск", about = "Горы — мой дом, треккинг — моя жизнь.", photoUrl = null),
        DatingProfile(id = "profile_90", name = "Сона", age = 29, city = "Абакан", about = "Хакасия — уникальная земля и я её часть.", photoUrl = null),
        DatingProfile(id = "profile_91", name = "Эля", age = 25, city = "Кызыл", about = "Тыва — особое место на карте и в сердце.", photoUrl = null),
        DatingProfile(id = "profile_92", name = "Арина", age = 22, city = "Чебоксары", about = "Люблю вышивку и народные промыслы.", photoUrl = null),
        DatingProfile(id = "profile_93", name = "Рима", age = 27, city = "Йошкар-Ола", about = "Город-сказка, жизнь-мечта.", photoUrl = null),
        DatingProfile(id = "profile_94", name = "Ляля", age = 24, city = "Саранск", about = "Мордовские узоры — мое вдохновение.", photoUrl = null),
        DatingProfile(id = "profile_95", name = "Ада", age = 28, city = "Ижевск", about = "Инженер-конструктор, собираю роботов для души.", photoUrl = null),
        DatingProfile(id = "profile_96", name = "Нина", age = 26, city = "Псков", about = "Люблю средневековые замки и рыцарские турниры.", photoUrl = null),
        DatingProfile(id = "profile_97", name = "Оля", age = 23, city = "Великий Новгород", about = "Древний город дарит особое ощущение времени.", photoUrl = null),
        DatingProfile(id = "profile_98", name = "Таня", age = 30, city = "Вологда", about = "Кружево, масло и тихая северная красота.", photoUrl = null),
        DatingProfile(id = "profile_99", name = "Жени", age = 25, city = "Петрозаводск", about = "Карелия — лучшее место для души и перезагрузки.", photoUrl = null),
        DatingProfile(id = "profile_100", name = "Соня", age = 27, city = "Мурманск", about = "Люблю северное сияние и бесконечную полярную ночь.", photoUrl = null)
    )

    private val profilesWhoLikedCurrentUser = setOf(
        "profile_2",
        "profile_5",
        "profile_8",
        "profile_11",
        "profile_14",
        "profile_17",
        "profile_20",
        "profile_23",
        "profile_26",
        "profile_29",
        "profile_33",
        "profile_37",
        "profile_41",
        "profile_44",
        "profile_48",
        "profile_52",
        "profile_56",
        "profile_60",
        "profile_63",
        "profile_67",
        "profile_71",
        "profile_75",
        "profile_80",
        "profile_85",
        "profile_92"
    )

    override fun getProfiles(): List<DatingProfile> {
        val unavailableProfileIds = likedProfileIds +
                skippedProfileIds +
                matches.map {match -> match.matchProfile.id}
        return profiles.filter { profile -> profile.id !in unavailableProfileIds}
    }

    override fun likeProfile(profileId: String): Match? {
        likedProfileIds.add(profileId)

        val profile = profiles.find { profile -> profile.id == profileId
        }?: return null

        val isMatch = profileId in profilesWhoLikedCurrentUser

        if (!isMatch) {
            return null
        }

        val existingMatch = matches.find { match -> match.matchProfile.id == profileId}

        if (existingMatch != null) {
            return existingMatch
        }

        val match = Match(
            id = "match_${profile.id}",
            matchProfile = profile
        )

        matches.add(match)

        return match
    }

    override fun skipProfile(profileId: String) {
        skippedProfileIds.add(profileId)
    }

    override fun getMatches(): List<Match> {
        return matches
    }

    override fun getMatchById(matchId: String): Match? {
        return matches.find {match ->
            match.id == matchId
        }
    }

}