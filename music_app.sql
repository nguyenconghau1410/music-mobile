-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2023 at 09:30 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `music_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `advertisement`
--

CREATE TABLE `advertisement` (
  `advertiseid` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `songid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `advertisement`
--

INSERT INTO `advertisement` (`advertiseid`, `content`, `image`, `songid`) VALUES
(1, 'Hồ Phi Nal', 'https://i.ytimg.com/vi/5EKrIQuRMEw/maxresdefault.jpg', 3),
(2, 'Khang Việt', 'https://vnw-img-cdn.popsww.com/api/v2/containers/file2/cms_topic/khangviet_05_seriesdetailimagemobile-f5f2555831e1-1614163144434-WgMhaidc.png?v=0', 15),
(3, 'Thành Đạt', 'https://photo-zmp3.zmdcdn.me/avatars/9/1/4/c/914ce9c9ec8344b7da84fe3e8a7ac247.jpg', 16),
(4, 'Châu Khải Phong', 'https://photo-zmp3.zmdcdn.me/avatars/c/9/a/e/c9aecf4e016a9f4f325251c05c4cda03.jpg', 17);

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE `album` (
  `albumid` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `singer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `album`
--

INSERT INTO `album` (`albumid`, `image`, `name`, `singer`) VALUES
(1, 'https://i.scdn.co/image/ab67616d0000b273145e1ed171d5cdfd470787c5', 'Nhạc trữ tình hay nhất', 'Đăng Nguyên'),
(2, 'https://photo-resize-zmp3.zmdcdn.me/w600_r1x1_jpeg/cover/5/9/4/f/594f4e9cab12eede42e3f04ec3c9e00f.jpg', 'Những bài hát hay nhất', 'Phan Mạnh Quỳnh'),
(3, 'https://yt3.googleusercontent.com/sQK-A90kC_VaH7f0vXzaKsX3hLN8U8OB65OY-oJV9WvJgKVKuMMxZdj-iaw3VKYLRr3kM5Pcjg=s900-c-k-c0x00ffffff-no-rj', 'Sao trời làm gió', 'Nal, CT'),
(4, 'https://photo-resize-zmp3.zmdcdn.me/w600_r1x1_jpeg/cover/f/4/d/5/f4d58e6307c6be993791754aa7d4d7eb.jpg', 'Anh khác hay em khác', 'Khắc Việt'),
(5, 'https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2022/7/4/1064129/Son-Tung-2.jpeg', 'Bài hát hay nhất', 'Sơn Tùng'),
(6, 'https://i.ytimg.com/vi/xHGVoDEKBpU/maxresdefault.jpg?sqp=-oaymwEmCIAKENAF8quKqQMa8AEB-AH-DoACuAiKAgwIABABGGUgZShlMA8=&rs=AOn4CLBbDf7uem4IQYRIknecjTS2PI52tg', 'Album Lofi by Freak D', 'Reddy ft Freak D'),
(7, 'https://upload.wikimedia.org/wikipedia/vi/c/cd/Taylor_Swift_-_Lover.png', 'Lover', 'Taylor Swift'),
(8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMvi0zz6RnicUcYPod-kDojsfPOzABlwngzKbSlDSN91n1REOIusq8qcWAovLu8FU3V0s&usqp=CAU', 'Album Hot - Nhiều người nghe', 'various Artist'),
(9, 'https://namchauims.com/wp-content/uploads/2019/02/bai-hat-nhat-ban.jpg', 'Nhạc Japan hay nhất', 'various Artist'),
(10, 'https://kienthuc24h.vn/img_data/images/su-khac-nhau-giua-nhac-vang-nhac-bolero-nhac-sen.jpg', 'Album Bolero chọn lọc', 'various Artist'),
(11, 'https://photo-resize-zmp3.zmdcdn.me/w600_r1x1_jpeg/covers/2/a/2a4ac9dc3b9cf1535f99966f3e6b4116_1470992373.jpg', 'Gửi anh xa nhớ (Single)', 'Bích Phương'),
(12, 'https://vnn-imgs-a1.vgcloud.vn/img.infonet.vn/w490/Uploaded/2020/rkjokv/2020_04_01/euxjybetkyhujjwkkeqgkpny8ufqmyphrtac083z_mpva.jpeg', 'Tháng tư lời nói dỗi của anh (Single)', 'Hà Anh Tuấn'),
(13, 'https://cdn.tgdd.vn/Files/2021/08/10/1374307/r-b-la-gi-tim-hieu-ve-cac-dong-nhac-va-the-loai-c-2.jpg', 'Album R&B', 'various Artist'),
(14, 'https://kenh14cdn.com/thumb_w/660/203336854389633024/2023/11/1/g-i-dle-for-y-magazine-issue-06-documents-1-16988288455901619182341.jpeg', 'Album nhạc Hàn', 'various Artist'),
(15, 'https://photo-resize-zmp3.zmdcdn.me/w256_r1x1_jpeg/cover/1/e/2/7/1e27b3d5f4b11dc5fa99d4d6f639f08b.jpg', 'Sao phải giữ (Single)', 'Khang Việt'),
(16, 'https://photo-resize-zmp3.zmdcdn.me/w600_r1x1_jpeg/cover/f/9/3/9/f9390ab7a26adbe59739fe2ba9470ee1.jpg', 'Ngày mai người ta lấy chồng', 'Thành Đạt'),
(17, 'https://avatar-ex-swe.nixcdn.com/song/2023/08/28/e/2/7/9/1693213847004_640.jpg', 'Anh đâu muốn thấy em buồn', 'Châu Khải Phong');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryid` bigint(20) NOT NULL,
  `topicid` bigint(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryid`, `topicid`, `image`, `name`) VALUES
(1, 6, 'https://avatar-ex-swe.nixcdn.com/topic/share/2022/08/08/b/6/7/a/1659944613058.jpg', 'K-POP'),
(2, 6, 'https://photo-resize-zmp3.zmdcdn.me/w600_r1x1_jpeg/cover/c/5/0/c/c50ca3d7607de6791edaf8380c39e243.jpg', 'V-POP'),
(3, 6, 'https://i1.sndcdn.com/artworks-000081294035-y8wqld-t500x500.jpg', 'POP BALLAD'),
(4, 6, 'https://avatar-ex-swe.nixcdn.com/playlist/share/2023/05/24/d/1/e/8/1684901837558.jpg', 'US-UK'),
(5, 1, 'https://i.scdn.co/image/ab67706c0000da844e5378f9af11ef43548cf455', 'J-POP'),
(6, 4, 'https://vietwebgroup.vn/admin/uploads/nhac-bolero-la-gi-tim-hieu-ve-nhac-bolero-la-gi.jpg', 'Bolero'),
(7, 4, 'https://media.istockphoto.com/id/1203264140/vector/rhythm-and-blues-vintage-3d-vector-lettering-retro-bold-font-typeface-pop-art-stylized-text.jpg?s=1024x1024&w=is&k=20&c=uZQ47ttba3x2c4m3D1BTXem7dy1_1g3GvEublDr8_ps=', 'R&B');

-- --------------------------------------------------------

--
-- Table structure for table `favorite`
--

CREATE TABLE `favorite` (
  `userid` bigint(20) NOT NULL,
  `songid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `favorite`
--

INSERT INTO `favorite` (`userid`, `songid`) VALUES
(2, 9),
(2, 10),
(2, 11),
(2, 12),
(2, 13),
(2, 36),
(2, 37),
(2, 39),
(2, 4),
(2, 5),
(2, 1),
(2, 2),
(2, 3),
(2, 31),
(2, 35),
(2, 34),
(4, 9),
(4, 10),
(4, 11),
(4, 12),
(4, 36),
(4, 37),
(4, 39),
(4, 40),
(4, 41),
(4, 1),
(4, 2),
(4, 3),
(4, 31),
(4, 32),
(4, 33),
(5, 9),
(5, 10),
(5, 11),
(5, 12),
(5, 13),
(5, 36),
(5, 1),
(5, 2),
(5, 3),
(5, 31),
(5, 32),
(5, 33),
(6, 22),
(6, 23),
(6, 24),
(6, 25),
(6, 38),
(6, 1),
(6, 2),
(6, 3),
(6, 31),
(6, 32),
(1, 1),
(1, 3),
(1, 2),
(1, 37),
(1, 35),
(1, 34),
(1, 31);

-- --------------------------------------------------------

--
-- Table structure for table `playlist`
--

CREATE TABLE `playlist` (
  `playlistid` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `playlist`
--

INSERT INTO `playlist` (`playlistid`, `image`, `name`, `userid`) VALUES
(26, NULL, 'my playlist', 1),
(27, NULL, 'SAD MUSIC', 1),
(28, NULL, 'playlist hay', 1),
(30, NULL, 'playlistttttttt', 6),
(31, NULL, 'Nhạc mơi', 1);

-- --------------------------------------------------------

--
-- Table structure for table `songs`
--

CREATE TABLE `songs` (
  `categoryid` bigint(20) DEFAULT NULL,
  `songid` bigint(20) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `singer` varchar(255) DEFAULT NULL,
  `albumid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `songs`
--

INSERT INTO `songs` (`categoryid`, `songid`, `link`, `name`, `singer`, `albumid`) VALUES
(3, 1, 'https://smallutilities.000webhostapp.com/Audio_Music/Anh-Se-Yeu-Nguoi-Ay-Hon-Em-Phan-Manh-Quynh.mp3', 'Anh Sẽ Yêu Người Ấy Hơn Em', 'Phan Mạnh Quỳnh', 2),
(3, 2, 'https://smallutilities.000webhostapp.com/Audio_Music/Khi-Phai-Quen-Di-Phan-Manh-Quynh.mp3', 'Khi Phải Quên Đi', 'Phan Mạnh Quỳnh', 2),
(3, 3, 'https://smallutilities.000webhostapp.com/Audio_Music/Minh-Tung-Yeu-Nhau-Phan-Manh-Quynh.mp3', 'Mình Từng Yêu Nhau', 'Phan Mạnh Quỳnh', 2),
(4, 4, 'https://smallutilities.000webhostapp.com/Audio_Music/Taylor%20Swift%20-%20The%20Man%20(Official%20Audio).mp3', 'The Man', 'Taylor Swift', 7),
(4, 5, 'https://smallutilities.000webhostapp.com/Audio_Music/Taylor%20Swift%20-%20The%20Archer%20(Lyric%20Video).mp3', 'The Archer', 'Taylor Swift', 7),
(4, 6, 'https://smallutilities.000webhostapp.com/Audio_Music/Taylor%20Swift%20-%20Lover%20(Official%20Music%20Video).mp3', 'Lover', 'Taylor Swift', 7),
(4, 7, 'https://smallutilities.000webhostapp.com/Audio_Music/Taylor%20Swift%20-%20I%20Forgot%20That%20You%20Existed%20(Official%20Audio).mp3', 'I Forgot That You Existed', 'Taylor Swift', 7),
(4, 8, 'https://smallutilities.000webhostapp.com/Audio_Music/Taylor%20Swift%20-%20Afterglow%20(Official%20Audio).mp3', 'Afterglow', 'Taylor Swift', 7),
(2, 9, 'https://smallutilities.000webhostapp.com/Audio_Music/\'bao%20ti%E1%BB%81n%20m%E1%BB%99t%20m%E1%BB%9B%20b%C3%ACnh%20y%C3%AAn-\'%20-%2014%20Casper%20&%20Bon%20Nghi%C3%AAm%20(Official)(Track%2009%20-%20Album%20\'S%E1%BB%90%20KH%C3%94NG\').mp3', 'Bao tiền một mớ bình yên', '14 Casper & Bon Nghiêm', 8),
(2, 10, 'https://smallutilities.000webhostapp.com/Audio_Music/Cause%20I%20Love%20You%20-%20Noo%20Ph%C6%B0%E1%BB%9Bc%20Th%E1%BB%8Bnh%20[Official%20Music%20Video].mp3', 'Cause I Love You', 'Noo Phước Thịnh', 8),
(2, 11, 'https://smallutilities.000webhostapp.com/Audio_Music/Ch%C3%BAng%20Ta%20Kh%C3%B4ng%20Thu%E1%BB%99c%20V%E1%BB%81%20Nhau%20-%20Official%20Music%20Video%20-%20S%C6%A1n%20T%C3%B9ng%20M-TP.mp3', 'Chúng ta không thuộc về nhau', 'Sơn Tùng MTP', 8),
(2, 12, 'https://smallutilities.000webhostapp.com/Audio_Music/MIN%20-%20TR%C3%8AN%20T%C3%8CNH%20B%E1%BA%A0N%20D%C6%AF%E1%BB%9AI%20T%C3%8CNH%20Y%C3%8AU%20-%20OFFICIAL%20MUSIC%20VIDEO.mp3', 'Trên tình bạn dưới tình yêu', 'MIN', 8),
(2, 13, 'https://smallutilities.000webhostapp.com/Audio_Music/MIN%20x%20%C4%90EN%20V%C3%82U%20x%20JUSTATEE%20-%20V%C3%8C%20Y%C3%8AU%20C%E1%BB%A8%20%C4%90%C3%82M%20%C4%90%E1%BA%A6U%20(VYC%C4%90%C4%90)%20-%20OFFICIAL%20MUSIC%20VIDEO.mp3', 'Vì yêu cứ đâm đầu', 'MIN x Đen Vâu x Justatee', 8),
(5, 14, 'https://smallutilities.000webhostapp.com/Audio_Music/AdoDIGNITY.mp3', 'AdoDIGNITY', 'Unknown', 9),
(5, 15, 'https://smallutilities.000webhostapp.com/Audio_Music/Fujii%20Kaze%20-%20Workin%20HardOfficial%20Video.mp3', 'Workin Hard', 'Fujii Kaze', 9),
(5, 16, 'https://smallutilities.000webhostapp.com/Audio_Music/Kimi%20ga%20Suki%20da%20to%20Sakebitai%20(Slam%20Dunk%20vietsub)%20vietsub.mp3', 'Kimi ga Suki da to', 'Sakebitai', 9),
(5, 17, 'https://smallutilities.000webhostapp.com/Audio_Music/Sakura%20Anata%20ni%20Deaete%20Yokatta%20-%205%20centimet%20per%20second%20-%20Lyric%20Kara%20HD.mp3', 'Sakura Anata ni Deaete Yokatta', 'Unknown', 9),
(6, 18, 'https://smallutilities.000webhostapp.com/Audio_Music/Chuyen-Tau-Hoang-Hon-Le-Quyen.mp3', 'Chuyến tàu hoàng hôn', 'Lệ Quyên', 10),
(6, 19, 'https://smallutilities.000webhostapp.com/Audio_Music/Dap-Mo-Cuoc-Tinh-Le-Sang.mp3', 'Đắp mộ cuộc tình', 'Lê Sang', 10),
(6, 20, 'https://smallutilities.000webhostapp.com/Audio_Music/Sau-Tim-Thiep-Hong-Quang-Le-Le-Quyen.mp3', 'Sầu tím thiệp hồng', 'Quang Lê x Lệ Quyên', 10),
(6, 21, 'https://smallutilities.000webhostapp.com/Audio_Music/Vung-La-Me-Bay-Nhu-Quynh.mp3', 'Vùng lá me bay', 'Như Quỳnh', 10),
(7, 22, 'https://smallutilities.000webhostapp.com/Audio_Music/B%C3%8DCH%20PH%C6%AF%C6%A0NG%20-%20G%E1%BB%ADi%20Anh%20Xa%20Nh%E1%BB%9B%20[OFFICIAL%20M-V].mp3', 'Gửi anh xa nhớ', 'Bích Phương', 11),
(7, 23, 'https://smallutilities.000webhostapp.com/Audio_Music/H%C3%A0%20Anh%20Tu%E1%BA%A5n%20-%20Th%C3%A1ng%20T%C6%B0%20L%C3%A0%20L%E1%BB%9Di%20N%C3%B3i%20D%E1%BB%91i%20C%E1%BB%A7a%20Em%20(Official%20MV).mp3', 'Tháng tư lời nói dối của em', 'Hà Anh Tuấn', 12),
(7, 24, 'https://smallutilities.000webhostapp.com/Audio_Music/R-B-Buon-Khong-Tu-Quynh.mp3', 'R&B Buồn', 'Khổng Tú Quỳnh', 13),
(7, 25, 'https://smallutilities.000webhostapp.com/Audio_Music/T%C3%ACnh%20Y%C3%AAu%20M%C3%A0u%20N%E1%BA%AFng%20-%20%C4%90%E1%BA%A1o%20Di%E1%BB%85n%20Tri%E1%BB%87u%20Quang%20Huy%20-%20%C4%90o%C3%A0n%20Th%C3%BAy%20Trang%20ft.%20Big%20Daddy%20-%20(Ninja%20Official%20', 'Tình yêu màu nắng', 'Đoàn Thúy Trang ft BigDaddy', 13),
(6, 26, 'https://smallutilities.000webhostapp.com/Audio_Music/Giot-Buon-Khong-Ten-Dang-Nguyen-Quynh-Vy.mp3', 'Giọt buồn không tên', 'Đăng Nguyên x Quỳnh Vy', 1),
(6, 27, 'https://smallutilities.000webhostapp.com/Audio_Music/Thiep-Hong-Anh-Viet-Ten-Em-Dang-Nguyen-Hong-Phuong.mp3', 'Thiệp hồng anh viết tên em', 'Đăng Nguyên x Hồng Phượng', 1),
(6, 28, 'https://smallutilities.000webhostapp.com/Audio_Music/Tinh-Dep-Mua-Chom-Chom-Dang-Nguyen-Quynh-Vi.mp3', 'Tình đẹp mùa chôm chôm', 'Đăng Nguyên x Quỳnh Vi', 1),
(6, 29, 'https://smallutilities.000webhostapp.com/Audio_Music_1/SAO%20TR%E1%BB%9CI%20L%C3%80M%20GI%C3%93%20-%20NAL%20-%20OFFICIAL%20MUSIC%20VIDEO%204K.mp3', 'Sao trời làm gió', 'Hồ Phi Nal', 3),
(6, 30, 'https://smallutilities.000webhostapp.com/Audio_Music_1/Sao%20Tr%E1%BB%9Di%20L%C3%A0m%20Gi%C3%B3%20(M-V%20Remake)%20-%20Nal%20-%20OFFICIAL.mp3', 'Sao trời làm gió (Remake)', 'Hồ Phi Nal', 3),
(3, 31, 'https://smallutilities.000webhostapp.com/Audio_Music_1/KH%E1%BA%AEC%20VI%E1%BB%86T%20-%20Anh%20Kh%C3%A1c%20Hay%20Em%20Kh%C3%A1c%20[Official].mp3', 'Anh khác hay em khác', 'Khắc Việt', 4),
(3, 32, 'https://smallutilities.000webhostapp.com/Audio_Music_1/KH%E1%BA%AEC%20VI%E1%BB%86T%20-%20Bi%E1%BA%BFt%20N%C3%B3i%20L%C3%A0%20T%E1%BA%A1i%20Sao%20(OFFICAL%20MV).mp3', 'Biết nói là tại sao', 'Khắc Việt', 4),
(3, 33, 'https://smallutilities.000webhostapp.com/Audio_Music_1/KH%E1%BA%AEC%20VI%E1%BB%86T%20-%20KH%C3%81C%20BI%E1%BB%86T%20-%20B%E1%BA%A2N%20PH%C3%92NG%20THU.mp3', 'Khác biệt', 'Khắc Việt', 4),
(3, 34, 'https://smallutilities.000webhostapp.com/Audio_Music_1/Anh%20Sai%20R%E1%BB%93i.mp3', 'Anh sai rồi', 'Sơn Tùng MTP', 5),
(3, 35, 'https://smallutilities.000webhostapp.com/Audio_Music_1/B%C3%ACnh%20Y%C3%AAn%20N%C6%A1i%20%C4%90%C3%A2u%20-%20S%C6%A1n%20T%C3%B9ng%20M-TP.mp3', 'Bình yên nơi đâu', 'Sơn Tùng MTP', 5),
(2, 36, 'https://smallutilities.000webhostapp.com/Audio_Music_1/N%C6%A0I%20N%C3%80Y%20C%C3%93%20ANH%20-%20OFFICIAL%20MUSIC%20VIDEO%20-%20S%C6%A0N%20T%C3%99NG%20M-TP.mp3', 'Nơi này có anh', 'Sơn Tùng MTP', 5),
(2, 37, 'https://smallutilities.000webhostapp.com/Audio_Music_1/S%C6%A1n%20T%C3%B9ng%20M-TP%20-%20Ch%E1%BA%AFc%20Ai%20%C4%90%C3%B3%20S%E1%BA%BD%20V%E1%BB%81.mp3', 'Chắc ai đó sẽ về', 'Sơn Tùng MTP', 5),
(7, 38, 'https://smallutilities.000webhostapp.com/Audio_Music_1/S%C6%A0N%20T%C3%99NG%20M-TP%20-%20MU%E1%BB%98N%20R%E1%BB%92I%20M%C3%80%20SAO%20C%C3%92N%20-%20OFFICIAL%20MUSIC%20VIDEO.mp3', 'Muộn rồi mà sao còn', 'Sơn Tùng MTP', 5),
(2, 39, 'https://smallutilities.000webhostapp.com/Audio_Music_1/-D%E1%BA%AAU%20TA%20C%C3%92N%20Y%C3%8AU-%20-%20REDDY%20-%20OFFICIAL%20MUSIC%20VIDEO.mp3', 'Dẫu ta còn yêu', 'Reddy', 6),
(2, 40, 'https://smallutilities.000webhostapp.com/Audio_Music_1/B%E1%BB%97ng%20D%C6%B0ng%20Mu%E1%BB%91n%20Kh%C3%B3c%20-%20Reddy%20Cover%20-%20Reply%20199X.mp3', 'Bỗng dưng muốn khóc', 'Reddy', 6),
(2, 41, 'https://smallutilities.000webhostapp.com/Audio_Music_1/Th%C3%AC%20Th%C3%B4i%20-%20Reddy%20-%20MV%20Lyrics%20Official.mp3', 'Thì thôi', 'Reddy', 6),
(2, 42, 'https://smallutilities.000webhostapp.com/Audio_Music_1/V%C3%A0i%20Gi%C3%A2y%20N%E1%BB%AFa%20Th%C3%B4i%20-%20Reddy%20-%20MV%20Lyrics%20Official.mp3', 'Vài giây nữa thôi', 'Reddy', 6),
(1, 43, 'https://smallutilities.000webhostapp.com/Audio_Music_1/[Vietsub]%20Once%20Again%20-%20Mad%20Clown%20ft%20Kim%20Na%20Young%20-%20Descendant%20Of%20The%20Sun%20OST%20Part%205.mp3', 'Once Again', 'Mad Clown ft Kim Na Young', 14),
(1, 44, 'https://smallutilities.000webhostapp.com/Audio_Music_1/[Vietsub+Eng+Kara%20]Talk%20Love-K.Will%20[OST%20-%20Descendants%20Of%20The%20Sun].mp3', 'Talk Love', 'K.Will', 14),
(1, 45, 'https://smallutilities.000webhostapp.com/Audio_Music_1/BIGBANG%20-%20HARU%20HARU(%ED%95%98%EB%A3%A8%ED%95%98%EB%A3%A8)%20M-V.mp3', 'HARU HARU', 'BIGBANG', 14),
(1, 46, 'https://smallutilities.000webhostapp.com/Audio_Music_1/BLACKPINK%20-%20\'Kill%20This%20Love\'%20M-V.mp3', 'Kill This Love', 'BlackPink', 14),
(1, 47, 'https://smallutilities.000webhostapp.com/Audio_Music_1/This%20Love%20-DAVICHI%20[Vietsub+Kara]%20OST%20Descendants%20of%20The%20Sun.mp3', 'This Love', 'DAVICHI', 14),
(2, 48, 'https://smallutilities.000webhostapp.com/Audio_Music_1/SAO%20PH%E1%BA%A2I%20GI%E1%BB%AE%20-%20KHANG%20VI%E1%BB%86T%20-%20OFFICIAL%20MUSIC%20VIDEO.mp3', 'Sao phải giữ', 'Khang Việt', 15),
(2, 49, 'https://smallutilities.000webhostapp.com/Audio_Music_1/Ng%C3%A0y%20mai%20ng%C6%B0%E1%BB%9Di%20ta%20l%E1%BA%A5y%20ch%E1%BB%93ng.mp3', 'Ngày mai người ta lấy chồng', 'Thành Đạt', 16),
(2, 50, 'https://smallutilities.000webhostapp.com/Audio_Music_1/ANH%20%C4%90%C3%82U%20MU%E1%BB%90N%20TH%E1%BA%A4Y%20EM%20BU%E1%BB%92N.mp3', 'Anh đâu muốn thấy em buồn', 'Châu Khải Phong', 17);

-- --------------------------------------------------------

--
-- Table structure for table `song_playlist`
--

CREATE TABLE `song_playlist` (
  `playlistid` bigint(20) NOT NULL,
  `songid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `song_playlist`
--

INSERT INTO `song_playlist` (`playlistid`, `songid`) VALUES
(27, 1),
(27, 3),
(27, 2),
(28, 2),
(28, 3),
(28, 1),
(28, 4),
(28, 5),
(28, 11),
(28, 12),
(30, 16),
(30, 29),
(30, 32),
(30, 33),
(26, 2),
(26, 1),
(26, 34),
(26, 9),
(26, 7);

-- --------------------------------------------------------

--
-- Table structure for table `topic`
--

CREATE TABLE `topic` (
  `topicid` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `topic`
--

INSERT INTO `topic` (`topicid`, `image`, `name`) VALUES
(1, 'https://img.freepik.com/free-photo/hands-holding-music-instruments_53876-148189.jpg?w=1380&t=st=1699369078~exp=1699369678~hmac=b325e8f4a791eba6600a30dac9e19442fbfcb76a36d80a79a91715346b578907', 'ROCK'),
(2, 'https://img.freepik.com/free-photo/abstract-watercolor-guitar-exploding-with-colorful-motion-generated-by-ai_188544-19725.jpg', 'AUSCOUTIC'),
(3, 'https://rukminim2.flixcart.com/image/850/1000/l01blow0/poster/2/w/z/medium-music-wallpaper-on-fine-art-paper-theme-images-hd-original-imagbx2phbqcnzym.jpeg?q=20', 'EDM'),
(4, 'https://img.freepik.com/premium-photo/music-wave-media-connection-concept-with-retro-radio-vintage-floating-pink-pastel-background-minimal-cartoon-style-banner-copy-space-3d-render-illustration_598821-1094.jpg?w=1060', 'LOVE MUSIC'),
(5, 'https://img.freepik.com/free-photo/friends-listening-music_53876-146919.jpg?w=1060&t=st=1699369562~exp=1699370162~hmac=05002975d365257a70161ce51f74c6ae2384b91514ceefad86893e3423e96a98', 'RAP'),
(6, 'https://photo2.tinhte.vn/data/attachment-files/2019/07/4724284_cover_tinhte_pop_music.jpg', 'POP');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roleid` bigint(20) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `email`, `password`, `roleid`, `token`, `name`) VALUES
(1, 'thanhbinh@gmail.com', 'thanhbinh123', 1, NULL, 'Hồ Thị Thanh Bình'),
(2, 'racingboy560@gmail.com', '123456', 1, '', 'Nguyễn Lê Văn Tèo'),
(4, 'teoem@gmail.com', '123456', 1, NULL, 'Nguyễn Văn Tèo'),
(5, 'vanti@gmail.com', '123456', 1, NULL, 'Lee Van Ti'),
(6, 'khakha@gmail.com', '1234567', 1, NULL, 'Khá Văn Bảnh'),
(7, '', '', 1, NULL, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertisement`
--
ALTER TABLE `advertisement`
  ADD PRIMARY KEY (`advertiseid`);

--
-- Indexes for table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`albumid`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryid`),
  ADD KEY `FKti7f8sowdaei18qblh6bdyrib` (`topicid`);

--
-- Indexes for table `favorite`
--
ALTER TABLE `favorite`
  ADD KEY `FKofqxayw8hb2j7i4sw10wy6m6v` (`songid`),
  ADD KEY `FK1nbbl8ows3xxgl9hy6r4ht5iy` (`userid`);

--
-- Indexes for table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`playlistid`),
  ADD KEY `FKb3q3dpmckl8l8yh0ovw8o8ixh` (`userid`);

--
-- Indexes for table `songs`
--
ALTER TABLE `songs`
  ADD PRIMARY KEY (`songid`),
  ADD KEY `FKbhguhffyoc77628eoeiv2xtnn` (`categoryid`),
  ADD KEY `FK4orrolaht28fud5c2fiohah0m` (`albumid`);

--
-- Indexes for table `song_playlist`
--
ALTER TABLE `song_playlist`
  ADD KEY `FKbleis0wmpx8gmkwu6h2vvifrk` (`songid`),
  ADD KEY `FKpoe3adbvup1m8r020dsh2pkgo` (`playlistid`);

--
-- Indexes for table `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`topicid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertisement`
--
ALTER TABLE `advertisement`
  MODIFY `advertiseid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `album`
--
ALTER TABLE `album`
  MODIFY `albumid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `playlistid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `songs`
--
ALTER TABLE `songs`
  MODIFY `songid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `topic`
--
ALTER TABLE `topic`
  MODIFY `topicid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `FKti7f8sowdaei18qblh6bdyrib` FOREIGN KEY (`topicid`) REFERENCES `topic` (`topicid`);

--
-- Constraints for table `favorite`
--
ALTER TABLE `favorite`
  ADD CONSTRAINT `FK1nbbl8ows3xxgl9hy6r4ht5iy` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  ADD CONSTRAINT `FKofqxayw8hb2j7i4sw10wy6m6v` FOREIGN KEY (`songid`) REFERENCES `songs` (`songid`);

--
-- Constraints for table `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `FKb3q3dpmckl8l8yh0ovw8o8ixh` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`);

--
-- Constraints for table `songs`
--
ALTER TABLE `songs`
  ADD CONSTRAINT `FK4orrolaht28fud5c2fiohah0m` FOREIGN KEY (`albumid`) REFERENCES `album` (`albumid`),
  ADD CONSTRAINT `FKbhguhffyoc77628eoeiv2xtnn` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`);

--
-- Constraints for table `song_playlist`
--
ALTER TABLE `song_playlist`
  ADD CONSTRAINT `FKbleis0wmpx8gmkwu6h2vvifrk` FOREIGN KEY (`songid`) REFERENCES `songs` (`songid`),
  ADD CONSTRAINT `FKpoe3adbvup1m8r020dsh2pkgo` FOREIGN KEY (`playlistid`) REFERENCES `playlist` (`playlistid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
