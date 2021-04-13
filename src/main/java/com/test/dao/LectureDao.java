package com.test.dao;

import com.test.dto.LectureDto;
import com.test.dto.LikesDto;
import com.test.mapper.LectureMapper;
import com.test.mapper.LikesMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class LectureDao {
    @Autowired
    SqlSession sqlSession;

    private final SimpleDateFormat dateForDB = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<LectureDto> readBasicDataList() {
        try {
            System.out.println("calling Lecture list do");
            LectureMapper lMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lMapper.readBasicDataList();
            System.out.println("calling Lecture list end");
            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertLecture(LectureDto lectureDto) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("lecture dao");
            lecMapper.insertLecture(lectureDto);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void deleteLecture(String lectureNo) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureNo);
            lecMapper.deleteLecture(lectureNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LectureDto readBasicDataByLecNo(String lectureNo) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureNo);
            return lecMapper.readBasicDataByLecNo(lectureNo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecName(String lectureName) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureName);
            return lecMapper.readBasicDataByLecName(lectureName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecCategory(String lectureCategory) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureCategory);
            return lecMapper.readBasicDataByLecCategory(lectureCategory);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecPrice(String minPrice, String maxPrice) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + minPrice + "~" + maxPrice);
            return lecMapper.readBasicDataByLecPrice(minPrice, maxPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateLecture(String lecNo, LectureDto updateDto) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lecNo);
            lecMapper.updateLecture(lecNo, updateDto);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public ArrayList<LectureDto> readBasicDataListByUserNo(String userNo) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + userNo);
            ArrayList<LectureDto> lectureInfoList = lecMapper.readBasicDataListByUserNo(userNo);
            return lectureInfoList;
        } catch (Exception e) {
            System.out.println("what error ㅜㅜ");
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<LectureDto> readAllLectureSortedByLikes() {
        try {
            LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lectureMapper.readAllLectureSortedByLikes();
            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<LectureDto> readBasicDataListByRegDateDesc() {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            return lecMapper.readBasicDataListByRegDateDesc();
        } catch (Exception e) {
            System.out.println("what error ㅜㅜ");

            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<LectureDto> readAllLectureSortedByRegDate() {
        try {
            LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lectureMapper.readAllLectureSortedByRegDate();
            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataListNotInRec() {
        try {
            System.out.println("calling Lecture list not in Recommended do");
            LectureMapper lMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lMapper.readBasicDataListNotInRec();
            System.out.println("calling Lecture list not in Recommended end");

            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<LectureDto> readLectureSortedByLikes(String category) {
        try {
            LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lectureMapper.readLectureSortedByLikes(category);
            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataListInRec() {
        try {
            System.out.println("calling Lecture list in Recommended do");
            LectureMapper lMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lMapper.readBasicDataListInRec();
            System.out.println("calling Lecture list in Recommended end");

            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readLectureSortedByRegDate(String category) {
        try {
            LectureMapper lectureMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lectureMapper.readLectureSortedByRegDate(category);
            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<LectureDto> readDataListByPopularity() {

        try {
            // 찜을 누를 때 동시 등록되는 날짜를 내림차순으로 불러옴 -> 무조건 첫 인덱스의 날짜는 가장 최근날짜
            // 이 날짜를 기점으로 같은 날짜에 있는 (중복되지 않게) 강의의 번호를 받아옴
            // 그 외에는 해당 날짜 이전의 강의들이니 제외
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            LikesMapper likesMapper = sqlSession.getMapper(LikesMapper.class);

            System.out.println("Popularity Dao start");
            ArrayList<LectureDto> recentLikedLectureList = new ArrayList<>();
            ArrayList<LikesDto> likesDtos = likesMapper.readLikesListsOrderByLikeDateDesc();

            if (!likesDtos.isEmpty()) {
                Date recentLikeDate = dateForDB.parse(likesDtos.get(0).getLikeDate());
                LectureDto firstRecentLikedLecture = lecMapper.readBasicDataByLecNo(likesDtos.get(0).getLecNo());
                recentLikedLectureList.add(firstRecentLikedLecture);

                for (int index = 1; index < likesDtos.size(); index++) {
                    if (recentLikedLectureList.size() < 7) {
                        String likeDate = likesDtos.get(index).getLikeDate();
                        int result = recentLikeDate.compareTo(dateForDB.parse(likeDate));
                        if (result == 0) {
                            boolean isAlreadyAdded = false;
                            for (LectureDto lectureDto : recentLikedLectureList) {
                                if (lectureDto.getLecNo().equals(likesDtos.get(index).getLecNo())) {
                                    // 강의번호가 중복 되는 것 방지
                                    isAlreadyAdded = true;
                                    break;
                                }
                            }
                            if (!isAlreadyAdded)
                                recentLikedLectureList.add(lecMapper.readBasicDataByLecNo(likesDtos.get(index).getLecNo()));
                        } else if (result > 0) {
                            break;
                        } else {
                            System.out.println("알 수 없는 오류 발생");
                            break;
                        }
                    } else {
                        break;
                    }
                }
                System.out.println("Popularity Dao end");
                return recentLikedLectureList;
            } else {
                // 찜 목록이 전혀 없는 경우 등록 날짜 순으로 데이터 정렬
                return lecMapper.readBasicDataListByRegDateDesc();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<LectureDto> readBasicDataListBySearch(String[] strQueries, String[] categories, String sortKey) {
        LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
        return lecMapper.readBasicDataListBySearch(strQueries, categories, sortKey);
    }
}
