    package T3H.QuanLySinhVien.Mapper;

    import T3H.QuanLySinhVien.Entities.dao.ClassroomDao;
    import T3H.QuanLySinhVien.Entities.dto.ClassroomDto;

    public class ClassroomMapper {
        public  static ClassroomDto mapClassroom(ClassroomDao classroomDao) {
            ClassroomDto classroomDto = new ClassroomDto();
            classroomDto.setClass_id(classroomDao.getClass_id());
            classroomDto.setClass_name(classroomDao.getClass_name());
            classroomDto.setQuantity(classroomDao.getQuantity());
            classroomDto.setMajor_id(classroomDao.getMajor_id());
            classroomDto.setTeacher_id(classroomDao.getTeacher_id());
            classroomDto.setCreated_at(classroomDao.getCreated_at());
            classroomDto.setUpdated_at(classroomDao.getUpdated_at());
            return classroomDto;
        }

    }
