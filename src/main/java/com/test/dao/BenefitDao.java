package com.test.dao;

import com.test.dto.BenefitDto;
import com.test.mapper.BenefitMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BenefitDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<BenefitDto> getBenefitList(){
        try{
            System.out.println("Benefit dto start");
            BenefitMapper benefitMapper = sqlSession.getMapper(BenefitMapper.class);
            System.out.println("Benefit dto end");
            return benefitMapper.getBenefitList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addItem(BenefitDto benefitDto){
        try{
            BenefitMapper benefitMapper = sqlSession.getMapper(BenefitMapper.class);
            benefitMapper.addItem(benefitDto);
            System.out.println("dao: " + benefitDto);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteItem(String benNo){
        try{
            BenefitMapper benefitMapper = sqlSession.getMapper(BenefitMapper.class);
            benefitMapper.deleteItem(benNo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editItem(BenefitDto benefitDto) {
        try{
            BenefitMapper benefitMapper = sqlSession.getMapper(BenefitMapper.class);
            benefitMapper.editItem(benefitDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BenefitDto selectItem(String benNo){
        try{
            BenefitMapper benefitMapper = sqlSession.getMapper(BenefitMapper.class);
            System.out.println("select: " + benNo);
            return benefitMapper.selectItem(benNo);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
